package c08overxxx

object Overloading:

  class Animal:
    def greet(a: Cat): Unit = println("Animal.greet")

  class Cat extends Animal:
    def greet(c: Animal): Unit = println("Cat.greet")

  val cat1: Animal = new Cat()
  val cat2: Cat = new Cat()
  cat1.greet(cat2)
