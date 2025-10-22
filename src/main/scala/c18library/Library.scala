package c18library
import scala.collection.mutable.{Set => Set}

class Library:
  type Name = String
  private val items: Set[Item] = Set()
  def isEmpty(): Boolean = items.size <= 0
  def add(item: Item) =
    items += item

  def searchByPredicate(p: Predicate): Set[Item] =
    items.filter(item => p.check(item))
