package c02IntroOOP.shapes

class Point(var x: Double, var y: Double) extends Movable {
  def move(dx: Double, dy: Double): Unit = {
    x += dx
    y += dy
  }
  override def toString(): String = {
    s"Point(${x}, ${y})"
  }

}
