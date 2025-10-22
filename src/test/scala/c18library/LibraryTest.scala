package c18library

import munit.FunSuite
import scala.collection.mutable.{Set => Set}
class LibraryTest extends FunSuite {
  var l: Library = new Library()
  val book1 = new Book("El libro Troll", 2015)
  val book2 = new Book("The Witcher", 2010)
  val game1 = new Steam("The Witcher", 2015)
  override def beforeEach(context: BeforeEach): Unit =
    l = new Library()
    l.add(book1)
    l.add(book2)
    l.add(game1)

  test("empty Library") {
    val l = new Library()
    assert(l.isEmpty())
  }
  test("non empty Library") {
    assert(!l.isEmpty())
  }
  test("search by name") {
    assertEquals(l.searchByPredicate(new ByName("El libro Troll")), Set(book1))
  }
  test("search by name not found") {
    assertEquals(l.searchByPredicate(new ByName("Spiderman")), Set())
  }
  test("search by name multiple items") {
    assertEquals(
      l.searchByPredicate(new ByName("The Witcher")),
      Set(book2, game1)
    )
  }
  test("search by year") {
    assertEquals(l.searchByPredicate(new ByYear(2015)), Set(book1, game1))
  }
  test("search by prefix") {
    assertEquals(l.searchByPredicate(new ByPrefix("The")), Set(book2, game1))
  }
  test("search by and") {
    assertEquals(
      l.searchByPredicate(
        new And(new ByName("The Witcher"), new ByYear(2015))
      ),
      Set(game1)
    )
  }
  test("search by or") {
    assertEquals(
      l.searchByPredicate(
        new Or(new ByName("The Witcher"), new ByYear(2015))
      ),
      Set(book1, book2, game1)
    )
    assertEquals(
      l.searchByPredicate(
        new And(
          new Or(new ByName("The Witcher"), new ByYear(2015)),
          new ByPrefix("E")
        )
      ),
      Set(book1)
    )
  }
  test("negation") {
    assertEquals(
      l.searchByPredicate(
        new Neg(new Or(new ByName("The Witcher"), new ByYear(2015)))
      ),
      Set()
    )
    assertEquals(
      l.searchByPredicate(
        new Neg(new ByYear(2015))
      ),
      Set(book2)
    )
  }
  test("search by game") {
    assertEquals(l.searchByPredicate(new ByVideoGame()), Set(game1))
  }
}
