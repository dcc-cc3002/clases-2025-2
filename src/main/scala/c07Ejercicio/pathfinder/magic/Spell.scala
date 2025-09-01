package c07Ejercicio.pathfinder.magic

import c07Ejercicio.pathfinder.entity.Entity

trait Spell:
  def castSpell(target: Entity): Unit
