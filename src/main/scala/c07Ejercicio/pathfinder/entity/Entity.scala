package c07Ejercicio.pathfinder.entity

trait Entity:
  def getName(): String
  def getHp(): Int // la vida
  def setHp(hp: Int): Unit
  def getStr(): Int // fuerza
  def getDex(): Int // destreza
  def getCon(): Int // constitucion
  def getInt(): Int // inteligencia
  def getWis(): Int // sabiduria
  def getCha(): Int // carisma

  def getInitiative(): Int // iniciativa
  def getAc(): Int // armadura

  def bab(): List[Int] // bonos de ataques

  def attack(target: Entity): Unit
  def getDamage(): Int

  def isAlive(): Boolean

  def play(target: Entity): Unit
