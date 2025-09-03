package c08overxxx

object Overriding:
  class A:
    def foo() = "hola"

  class B extends A:
    override def foo() = "chao"

  class C extends A:
    override def foo() = "pescao"

  def saluda(x: A): Unit = x.foo()

  def main(args: Array[String]): Unit =
    val a = new A()
    val b = new B()
    val c = new C()

    saluda(a)
    saluda(b)
    saluda(c)
