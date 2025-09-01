package c07Ejercicio.pathfinder.magic.transmutation

import c07Ejercicio.pathfinder.D6
import c07Ejercicio.pathfinder.entity.Entity
import c07Ejercicio.pathfinder.magic.{Spell, Transmutation}

class Disintegrate extends Spell with Transmutation:
  def castSpell(target: Entity): Unit =
    val damage = new D6().roll(2) + 40
    println(s"Casting Disintegrate on $target, dealing $damage damage.")
    target.setHp(target.getHp() - damage)
