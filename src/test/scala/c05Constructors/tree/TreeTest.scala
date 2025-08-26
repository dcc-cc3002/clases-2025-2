package c05Constructors.tree

import c05Constructors.tree.*
import munit.FunSuite

class TreeTest extends FunSuite {

  val tree: Tree =
    new Node(45, new Node(34, new Leaf(13), new Leaf(25)), new Leaf(4))
  test("suma de elementos de un arbol") {
    assertEquals(121, tree.sum)
  }
  test("minimo de elementos de un arbol") {
    assertEquals(4, tree.min)
  }
  test("maximo de elementos de un arbol") {
    assertEquals(45, tree.max)
  }

  test("arbol con 1 hijo ") {
    val tree: Tree = new Node(45, new Leaf(13), new Empty())
    assertEquals(58, tree.sum)
    assertEquals(13, tree.min)
    assertEquals(45, tree.max)
  }
}
