package c02IntroOOP.shapes

class Rectangle(var p: Point, width: Double, height: Double) extends Movable {
  def move(dx: Double, dy: Double): Unit = {
    p.move(dx, dy)
  }
  def area(): Double = width * height
}
