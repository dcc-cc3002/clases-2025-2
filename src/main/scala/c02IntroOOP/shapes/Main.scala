package c02IntroOOP.shapes

def move(m: Movable) = {
  m.move(10, 10)
}
@main def main() =
  val p = new Point(2.0, 5.0)
  val r = new Rectangle(p, 100, 300)
  p.move(1, 1)
  r.move(2, 2)
  println(s"El rectangulo se movio a ${r.p}")
  move(p)
  move(r)
