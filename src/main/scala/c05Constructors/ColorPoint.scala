package c05Constructors

import java.awt.Color

class ColorPoint(var x: Double, var y: Double) {
  var color: Option[Color] = None
}

@main
def maincolors(): Unit = {
  val cp = new ColorPoint(0.0, 1.0)
  if (cp.color.isDefined)
    cp.color.get.getRGB()
}
