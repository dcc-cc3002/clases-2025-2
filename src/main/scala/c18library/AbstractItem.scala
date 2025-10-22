package c18library

class AbstractItem(name: String, year: Int) extends Item:
  override def getName() = name
  override def getYear() = year
