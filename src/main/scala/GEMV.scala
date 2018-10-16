import spatial.dsl._

@spatial object GEMV extends SpatialApp {

  type T = FixPt[TRUE,_10,_22]

  val N = 1024  // A is NxN, and x is N wide.

  def main(args: Array[String]): Unit = {

    // These are on the HOST
    val x_host = loadCSV1D[T]("vector.csv")
    val A_host = loadCSV2D[T]("matrix.csv")

    Accel {
      
      // TODO: Add in your accelerator code here

    }

    // TODO: Write output using writeCSV1D to output.csv
  }
}
