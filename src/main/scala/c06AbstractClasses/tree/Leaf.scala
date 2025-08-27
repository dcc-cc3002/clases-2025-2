package c06AbstractClasses.tree

class Leaf(val value: Int) extends AbstractTree {
  def sum: Int = value

  def min: Int = value

  def max: Int = value

}
