import spatial.dsl._
import virtualized._
import spatial.targets._

object App extends SpatialApp {
  @virtualize
  def main() {
    // Your code here
    val x = ArgIn[Int]
    setArg(x, args(0).to[Int])

    val y = ArgOut[Int]

    Accel {
      y := x + 4
    }
    
    println("Result: " + x + " + 4 = " + getArg(y))
  }
}
