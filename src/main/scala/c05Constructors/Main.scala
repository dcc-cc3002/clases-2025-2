package c05Constructors

object Main {
  def sacarAPasear(a: Legged) = {
    a.walk()
  }
  def main(args: Array[String]): Unit = {
    val dog: Legged  = new AkitaIno()
    dog.walk()
    sacarAPasear(dog)
    val persona = new Person()
    sacarAPasear(persona)

  }
}
