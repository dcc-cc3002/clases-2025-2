package c18library

trait Predicate:
  def check(item: Item): Boolean

class ByName(name: String) extends Predicate:
  override def check(item: Item): Boolean = item.getName() == name

class ByYear(year: Int) extends Predicate:
  override def check(item: Item): Boolean = item.getYear() == year

class ByPrefix(prefix: String) extends Predicate:
  override def check(item: Item): Boolean = item.getName().startsWith(prefix)

class And(left: Predicate, right: Predicate) extends Predicate:
  override def check(item: Item): Boolean =
    left.check(item) && right.check(item)

class Or(left: Predicate, right: Predicate) extends Predicate:
  override def check(item: Item): Boolean =
    left.check(item) || right.check(item)

class Neg(p: Predicate) extends Predicate:
  override def check(item: Item): Boolean = !p.check(item)

class ByVideoGame() extends Predicate:
  override def check(item: Item): Boolean = ??? // To be continued...
