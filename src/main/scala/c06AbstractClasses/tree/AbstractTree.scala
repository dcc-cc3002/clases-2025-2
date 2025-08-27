package c06AbstractClasses.tree

abstract class AbstractTree extends Tree {
  def compareTo(other: Tree) = {
    sum - other.sum
  }
}
