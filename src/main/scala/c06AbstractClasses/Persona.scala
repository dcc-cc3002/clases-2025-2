package c06AbstractClasses

trait MyComparable[T] {
  def compareTo(other: T): Int
}

class Persona(val nombre: String, val edad: Int) extends Comparable[Persona] {
  def saludar(): Unit = {
    println(s"Hola, mi nombre es $edad y tengo $nombre años.")
  }
  def compareTo(other: Persona): Int = {
    val result = edad - other.edad
    if (result == 0) {
      nombre.compareTo(other.nombre)
    } else result
  }
  override def toString(): String = {
    s"Persona(${nombre}, ${edad})"
  }
}

@main
def foo() = {
  val p11 = new Persona("El coleccionista 1", 20)
  val p12 = new Persona("El coleccionista 2", 20)
  val p2 = new Persona("El inversionista", 21)
  val p3 = new Persona("El villano", 14)
  val p4 = new Persona("LorDona", 8)
  val lista = List(p12, p11, p3, p4, p2)
  println(lista.sorted)
}
