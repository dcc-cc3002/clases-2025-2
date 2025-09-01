package c07Ejercicio.pathfinder.entity.player

import c07Ejercicio.pathfinder.D6
import c07Ejercicio.pathfinder.entity.{AbstractEntity, Entity, SpellCaster}
import c07Ejercicio.pathfinder.magic.conjuration.CureLightWounds
import c07Ejercicio.pathfinder.magic.Spell

class Cleric(name: String)
    extends AbstractEntity(name, 20, 12, 10, 16, 8, 18, 8)
    with Player
    with SpellCaster:

  def getDamage() = new D6().roll(1) + (getStr() - 10) / 2

  val spells: List[Spell] = List(new CureLightWounds())
  def cast(other: Entity): Unit =
    println(s"$this is casting a spell on $other ...")
    spells.head.castSpell(other)

  def play(target: Entity) = cast(target)
