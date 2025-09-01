package c07Ejercicio.pathfinder.entity.player

import c07Ejercicio.pathfinder.{D4, D6}
import c07Ejercicio.pathfinder.entity.{AbstractEntity, Entity, SpellCaster}
import c07Ejercicio.pathfinder.magic.Spell
import c07Ejercicio.pathfinder.magic.conjuration.CureLightWounds
import c07Ejercicio.pathfinder.magic.evocation.MagicMissile
import c07Ejercicio.pathfinder.magic.transmutation.Disintegrate

class Wizard(name: String)
    extends AbstractEntity(name, 10, 8, 16, 10, 18, 10, 8)
    with Player
    with SpellCaster:

  def getDamage() = new D4().roll(1) + (getStr() - 10) / 2

  val spells: List[Spell] = List(new MagicMissile(), new Disintegrate())
  def cast(other: Entity): Unit =
    // choose a spell randomly
    println(s"$this is casting a spell on $other ...")
    val spell = spells(scala.util.Random.nextInt(spells.length))
    spell.castSpell(other)

  def play(target: Entity) = cast(target)
