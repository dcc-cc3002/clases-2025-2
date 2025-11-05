package c20expressionproblem

object ExpressionProblemOOP {
  trait Expr:
    def eval: Int
    def pprint: String

  case class Lit(value: Int) extends Expr:
    def eval: Int = value
    def pprint: String = value.toString

  case class Add(left: Expr, right: Expr) extends Expr:
    def eval: Int = left.eval + right.eval
    def pprint: String = s"(${left.pprint} + ${right.pprint})"

  // No tocar el codigo que esta arriba es barato.
  // Tocar el codigo que esta arriba es caro

  // Primera extension: Sustraccion
  case class Subst(left: Expr, right: Expr) extends Expr:
    def eval: Int = left.eval - right.eval
    def pprint: String = s"(${left.pprint} - ${right.pprint})"
  // costo: es barato!

  // Segunda extension: pprint
  // no podemos hacer esto sin modificar codigo exitente
  // costo: carisimo!

  def main(args: Array[String]): Unit = {
    println(Add(Lit(1), Lit(2)).eval) // Should print 3
    println(Add(Lit(10), Add(Lit(20), Lit(30))).eval) // Should print 60
    println(Subst(Lit(100), Add(Lit(20), Lit(30))).eval) // Should print 50

    println(Add(Lit(1), Lit(2)).pprint) // Should print "(1 + 2)"
    val expr = Subst(Lit(100), Add(Lit(20), Lit(30)))
    println(s"${expr.pprint} = ${expr.eval}")
  }
}

object ExpressionProblemFP {
  sealed trait Expr
  case class Lit(value: Int) extends Expr
  case class Add(left: Expr, right: Expr) extends Expr
  def eval(e: Expr): Int =
    e match {
      case Lit(v)             => v
      case Add(left, right)   => eval(left) + eval(right)
      case Subst(left, right) => eval(left) - eval(right)
    }

  // Primera extension: agregar la variante Subst
  // tocar arriba: alto
  // tocar abajo: bajo
  // costo: ALTO

  case class Subst(left: Expr, right: Expr) extends Expr

  // Segunda extension: agregar funcion pprint
  def pprint(e: Expr): String =
    e match {
      case Lit(n)             => n.toString
      case Add(left, right)   => s"(${pprint(left)} + ${pprint(right)})"
      case Subst(left, right) => s"(${pprint(left)} - ${pprint(right)})"
    }
  // cost: BAJO

  def main(args: Array[String]): Unit = {
    println(eval(Add(Lit(1), Lit(2)))) // Should print 3
    println(eval(Add(Lit(10), Add(Lit(20), Lit(30))))) // Should print 60
    println(eval(Subst(Lit(100), Add(Lit(20), Lit(30))))) // Should print 50
    val expr = Subst(Lit(100), Add(Lit(20), Lit(30)))
    println(s"${pprint(expr)} = ${eval(expr)}")
  }
}

object ExpressionProblemASolution {
  trait Expr:
    def eval: Int

  trait Lit extends Expr:
    val value: Int
    override def eval: Int = value

  trait Add extends Expr:
    def left: Expr
    def right: Expr
    override def eval: Int = left.eval + right.eval

  // Extension 1: Subtraction
  trait Subst extends Expr:
    def left: Expr
    def right: Expr
    override def eval: Int = left.eval - right.eval
  // Costo: BAJO

  // Extension 2: nueva operacion pprint
  trait ExprWithPprint extends Expr:
    def pprint: String

  trait LitWithPprint extends Lit with ExprWithPprint:
    override def pprint: String = value.toString

  trait AddWithPprint extends Add with ExprWithPprint:
    override def left: ExprWithPprint
    override def right: ExprWithPprint

    override def pprint: String = s"(${left.pprint} + ${right.pprint})"

  trait SubstWithPprint extends Subst with ExprWithPprint:
    override def left: ExprWithPprint
    override def right: ExprWithPprint

    override def pprint: String = s"(${left.pprint} - ${right.pprint})"

  // costo: BAJO

  // Extension 3: collect all literals in the expression
  // ((1 + 2) + 3).collect = List(1,2,3)
  trait ExprWithCollect extends Expr:
    def collect: List[Int]

  trait LitWithCollect extends Lit with ExprWithCollect:
    override def collect: List[Int] = List(value)

  trait AddWithCollect extends Add with ExprWithCollect:
    override def left: ExprWithCollect
    override def right: ExprWithCollect
    override def collect: List[Int] = left.collect ++ right.collect

  trait SubstWithCollect extends Subst with ExprWithCollect:
    override def left: ExprWithCollect
    override def right: ExprWithCollect
    override def collect: List[Int] = left.collect ++ right.collect

  // extension 4: pprint AND collect
  trait ExprWPC extends ExprWithPprint with ExprWithCollect
  trait LitWPC extends LitWithPprint with LitWithCollect with ExprWPC
  trait AddWPC extends AddWithPprint with AddWithCollect with ExprWPC:
    override def left: ExprWPC
    override def right: ExprWPC
  trait SubstWPC extends SubstWithPprint with SubstWithCollect with ExprWPC:
    override def left: ExprWPC
    override def right: ExprWPC

  // costo: BAJO

  def main(args: Array[String]): Unit = {
    val expr = new Subst {
      val left = new Lit { val value = 100 }
      val right = new Add {
        val left = new Lit { val value = 20 }
        val right = new Lit { val value = 30 }
      }
    }
    println(expr.eval) // Should print 150

    val expr2 = new SubstWithPprint {
      val left = new LitWithPprint { val value = 100 }
      val right = new AddWithPprint {
        val left = new LitWithPprint { val value = 20 }
        val right = new LitWithPprint { val value = 30 }
      }
    }
    println(
      s"${expr2.pprint} = ${expr2.eval}"
    ) // Should print "(100 - (20 + 30)) = 50"

    val expr3 = new SubstWithCollect {
      val left = new LitWithCollect { val value = 100 }
      val right = new AddWithCollect {
        val left = new LitWithCollect { val value = 20 }
        val right = new LitWithCollect { val value = 30 }
      }
    }
    println(expr3.collect) // Should print List(100, 20, 30)

    val expr4 = new SubstWPC {
      val left = new LitWPC { val value = 100 }
      val right = new AddWPC {
        val left = new LitWPC { val value = 20 }
        val right = new LitWPC { val value = 30 }
      }
    }
    println(
      s"${expr4.pprint} = ${expr4.eval}, literals: ${expr4.collect}"
    ) // Should print "(100 - (20 + 30)) = 50, literals: List(100, 20, 30)"
  }
}
