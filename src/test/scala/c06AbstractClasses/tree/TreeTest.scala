package c06AbstractClasses.tree

import munit.FunSuite

class TreeTest extends FunSuite {
  val tree1 =
    new Node(45, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(4))
  val tree2 = new Node(100, new Leaf(53), new Leaf(2))

  test("comparar dos arboles por su suma") {
    assert(tree1.compareTo(tree2) < 0)
    assert(tree2.compareTo(tree1) > 0)
    assertEquals(0, tree1.compareTo(tree1))
  }

}
