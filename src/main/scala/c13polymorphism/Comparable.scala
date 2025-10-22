package c13polymorphism

class Person(val name: String, val age: Int) extends Comparable[Person]:
  override def compareTo(other: Person): Int =
    val r = age.compareTo(other.age)
    if (r == 0)
      name.compareTo(other.name)
    else r

class Foo extends Comparable[Foo]:
  override def compareTo(other: Foo): Int = ???

def sort[T <: Comparable[T]](l: List[T]): List[T] =
  ???

@main def foo =
  sort(List(new Person("Juan", 20), new Person("Maria", 10)))
