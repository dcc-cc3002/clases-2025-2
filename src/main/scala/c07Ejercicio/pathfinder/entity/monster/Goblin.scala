package c07Ejercicio.pathfinder.entity.monster

import c07Ejercicio.pathfinder.entity.{AbstractEntity, Entity}
import c07Ejercicio.pathfinder.{D20, D4, D8}

class Goblin
    extends AbstractEntity("Goblin", 10, 12, 11, 10, 8, 8, 8)
    with Monster:
  def getDamage() = new D4().roll(1) + (getStr() - 10) / 2

  def play(target: Entity) = attack(target)
