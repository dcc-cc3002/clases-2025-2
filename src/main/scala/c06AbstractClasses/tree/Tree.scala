package c06AbstractClasses.tree

trait Tree extends Comparable[Tree] {
  def sum: Int
  def min: Int
  def max: Int
}
