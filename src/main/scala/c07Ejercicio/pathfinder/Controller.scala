package c07Ejercicio.pathfinder

import c07Ejercicio.pathfinder.core.TurnContext
import c07Ejercicio.pathfinder.entity.player.*
import c07Ejercicio.pathfinder.entity.monster.*

object Controller {
  val party: List[Player] = List(
    new Fighter("El musculos"),
    new Wizard("El magias"),
    new Cleric("El curas")
  )
  val monsters: List[Monster] =
    List(new Goblin(), new Goblin(), new Goblin())
  val turnContext = new TurnContext(party ++ monsters)

  def main(args: Array[String]): Unit = {
    println("Comienza la aventura!")
    println(s"Tu party: ${party.mkString(", ")}")
    println("El orden es el siguiente:")
    turnContext
      .getOrder()
      .foreach(e => println(s"- ${e}"))

    // while (party.exists(_.isAlive()) && monsters.exists(_.isAlive())) {

    party(0).play(monsters(0))
    party(1).play(monsters(0))
    party(2).play(party(0))
  }

}
