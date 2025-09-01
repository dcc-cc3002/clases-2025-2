package c07Ejercicio.pathfinder.entity.player

import c07Ejercicio.pathfinder.entity.{AbstractEntity, Entity}
import c07Ejercicio.pathfinder.{D20, D8}

class Fighter(name: String)
    extends AbstractEntity(name, 30, 18, 14, 16, 10, 8, 8)
    with Player:
  def getDamage() = new D8().roll(1) + (getStr() - 10) / 2

  def play(target: Entity) = attack(target)
