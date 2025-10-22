package c14subtypinggenerics

import scala.collection.mutable.ListBuffer

trait Animal

trait Pet extends Animal

class Container[T >: Pet <: Animal] {
  val internalList = ListBuffer[T]()
  def addElement(e: T): Unit = internalList.addOne(e)
  def getElements(): List[T] = internalList.toList

}
