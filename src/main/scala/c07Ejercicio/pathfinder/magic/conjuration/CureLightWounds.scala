package c07Ejercicio.pathfinder.magic.conjuration

import c07Ejercicio.pathfinder.D8
import c07Ejercicio.pathfinder.entity.Entity
import c07Ejercicio.pathfinder.magic.{Conjuration, Spell}

class CureLightWounds extends Spell with Conjuration:
  def castSpell(target: Entity): Unit =

    val heal = new D8().roll(1) + 1
    println(
      s"Casting Cure Light Wounds on ${target}, healing $heal points of damage."
    )
    target.setHp(target.getHp() + heal)
