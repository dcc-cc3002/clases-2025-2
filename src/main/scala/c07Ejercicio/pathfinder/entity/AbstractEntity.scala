package c07Ejercicio.pathfinder.entity

import c07Ejercicio.pathfinder.{D20}

abstract class AbstractEntity(
    private val name: String,
    private var _hp: Int,
    private val str: Int,
    private val dex: Int,
    private val con: Int,
    private val int: Int,
    private val wis: Int,
    private val cha: Int
) extends Entity:

  override def getName() = name

  override def getHp() = _hp

  override def setHp(hp: Int) =
    _hp = hp

  override def getStr() = str

  override def getDex() = dex

  override def getCon() = con

  override def getInt() = int

  override def getWis() = wis

  override def getCha() = cha

  def getInitiative() = new D20().roll(1) + (dex - 10) / 2

  def getAc() = 10 + (dex - 10) / 2 // armadura de placas +1

  def bab() = List(2, 1)

  def getAttacks(): List[Int] =
    bab().map(b => b + (str - 10) / 2 + new D20().roll(1))

  def attack(target: Entity) =
    println(s"${getName()} ataca a ${target.getName()}: ")
    getAttacks().foreach { attack =>
      if attack >= target.getAc() then
        val damage = getDamage()
        println(
          s"${this} ataca a ${target} con un ataque de $attack y causa $damage puntos de daño."
        )
        target.setHp(target.getHp() - damage)
        println(
          s"${target} tiene ${target.getHp()} puntos de vida restantes."
        )
      else
        println(
          s"${this} ataca a ${target} con un ataque de $attack y falla."
        )

    }

  def isAlive() = _hp > 0

  override def toString() = s"$name"
