package c05Constructors.tree

class Node(val value: Int, val left: Tree, val right: Tree) extends Tree {

  def sum: Int = value + left.sum + right.sum

  def min: Int = Math.min(value, Math.min(left.min, right.min))

  def max: Int = Math.max(value, Math.max(left.max, right.max))
}
