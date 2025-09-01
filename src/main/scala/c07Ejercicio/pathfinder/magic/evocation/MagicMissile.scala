package c07Ejercicio.pathfinder.magic.evocation

import c07Ejercicio.pathfinder.D4
import c07Ejercicio.pathfinder.entity.Entity
import c07Ejercicio.pathfinder.magic.{Evocation, Spell}

class MagicMissile extends Spell with Evocation:
  def castSpell(target: Entity): Unit =
    val damage = new D4().roll(1) + 1
    println(s"Casting Magic Missile on ${target}, dealing $damage damage.")
    target.setHp(target.getHp() - damage)
