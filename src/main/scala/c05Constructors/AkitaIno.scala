package c05Constructors

class AkitaIno extends Legged {
  val numLegs = 4
  def walk() =
    println("Estoy caminando!")
}

class Person extends Legged {
  val numLegs = 2
  def walk() =
    print("Mira mama, estoy caminando")
}
