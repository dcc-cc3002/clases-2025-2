package c14subtypinggenerics

trait Vehicle
class Car extends Vehicle
class Bicycle extends Vehicle

class Showroomv1[-T <: Vehicle]:
  def store(v: T): Unit = ???

class Showroomv2[+T <: Vehicle]:
  def present(): T = ???

class Garage[T <: Vehicle]:
  def store(v: T): Unit = ???
  def retrieve(): T = ???

class RepairShop[-T <: Vehicle]:
  def repair(v: T): Unit = ???
