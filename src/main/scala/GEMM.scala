import spatial.dsl._

@spatial object GEMM extends SpatialApp {
  type T = FixPt[TRUE,_16,_16]

  def main(args: Array[String]): Unit = {
    // Get matrix dimensions from command line
    val m = args(0).to[Int]; bound(m) = 512
    val n = args(1).to[Int]; bound(n) = 256
    val p = args(2).to[Int]; bound(p) = 512

    // Pass dimensions to Accel
    val M = ArgIn[Int]
    val N = ArgIn[Int]
    val P = ArgIn[Int]
    setArg(M,m)
    setArg(N,n)
    setArg(P,p)

    // Allocate DRAM for matrices
    val A = DRAM[T](M, N)
    val B = DRAM[T](N, P)
    val C = DRAM[T](M, P)

    // Initialize data
    val a = (0::M,0::N){(i,j) => ((i*N + j)%8).to[T] }
    val b = (0::N,0::P){(i,j) => ((i*P + j)%8).to[T] }
    setMem(A,a)
    setMem(B,b)

    // Expose tile sizes as DSE parameters
    val bm = 16 (16 -> 8 -> 64)
    val bn = 16 (16 -> 16 -> 128)
    val bp = 16 (16 -> 16 -> 128)

    // Expose parallelization factors as DSE parameters
    val tileM_par = 1   (1 -> 3)
    val tileP_par = 2   (1 -> 3)
    val M_par = 1 (1 -> 2 -> 4)
    val P_par = 2 (1 -> 2 -> 4)
    val ip = 2  (1,2,8,32)
    val load_par = 4   (1,2,4,8,16)
    val store_par = 4   (1,2,4,8,16)

    // Design accelerator
    Accel {
      Foreach(M by bm par tileM_par, P by bp par tileP_par){(i,j) =>
        val tileC = SRAM[T](bm, bp)
        Foreach(N by bn){k =>
          val tileA = SRAM[T](bm, bn)
          val tileB = SRAM[T](bn, bp)
          tileA load A(i::i+bm, k::k+bn par load_par)
          tileB load B(k::k+bn, j::j+bp par load_par)
          Foreach(bm by 1 par M_par, bp by 1 par P_par){ (ii,jj) =>
            val prod = Reduce(Reg[T])(bn by 1 par ip){kk => tileA(ii, kk) * tileB(kk, jj) }{_+_}
            val prev = mux(k == 0, 0.to[T], tileC(ii,jj))
            tileC(ii,jj) = prev + prod.value
          }
        }
        C(i::i+bm, j::j+bp par store_par) store tileC
      }
    }

    // Compute expected matrix
    val gold = (0::M,0::P){(i,j) =>
      Array.tabulate(N){k => a(i,k) * b(k,j)}.reduce{_+_}
    }

    // Check result
    printMatrix(getMatrix(C), "Got: ")
    printMatrix(gold, "Wanted: ")
    println(r"PASS: ${gold === getMatrix(C)}")
    assert(gold === getMatrix(C))
  }

}


