package c07Ejercicio.pathfinder

trait Dice:
  def roll(num: Int): Int

abstract class AbstractDice(size: Int) extends Dice:
  def roll(num: Int): Int =
    val rnd = new scala.util.Random()
    (1 to num).map(_ => rnd.nextInt(size) + 1).sum

class D4 extends AbstractDice(4)
class D6 extends AbstractDice(6)
class D8 extends AbstractDice(8)
class D10 extends AbstractDice(10)
class D12 extends AbstractDice(12)
class D20 extends AbstractDice(20)
