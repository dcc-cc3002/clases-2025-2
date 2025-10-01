package c12polymorphism

trait Opcion[T]: // por que el +???
  def isEmpty: Boolean
  def get: T
  // usaremos type bounds!!
  def getOrElse[S >: T](default: => S): S

class Algo[T](v: T) extends Opcion[T]:
  def isEmpty: Boolean = false
  def get: T = v
  def getOrElse[S >: T](default: => S): S = v

class Nada extends Opcion[Nothing]:
  def isEmpty: Boolean = true
  def get: Nothing = throw new Exception("No se puede hacer get de la Nada")
  def getOrElse[S](default: => S): S = default

@main def foo(): Unit = {
  val x: Opcion[Nothing] = new Nada()
  x.getOrElse(2)

  /** demorate 10 segundos en retornar un entero */
  def longComputation(): Int = {
    Thread.sleep(10000)
    42
  }
  // x.getOrElse(longComputation())

  val y: Opcion[Int] = new Algo(1)
  y.getOrElse(longComputation())

  /*Algo(1).isEmpty --> false
  Algo(1).get ---> 1
  Algo(1).getOrElse(2) ---> 1

  Nada.isEmpty --> true
  Nada.get ---> throw new Exception()
  Nada.getOrElse(2) ---> 2*/

  def f(x: Int) = x + x
  def g() =
    println("hola")
    42
  println(f(g())) // imprime hola y despues 84

  def h(x: => Int) = x + x
  println(h(g())) // equivalente a: g() + g()

  lazy val foo = {
    println("lazy")
    42
  }

  foo + foo

}
