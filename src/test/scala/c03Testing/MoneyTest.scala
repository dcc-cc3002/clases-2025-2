package c03Testing

class MoneyTest extends munit.FunSuite {
  var _12clp: Money = null
  var _14clp: Money = null

  override def beforeEach(context: BeforeEach): Unit = {
    _12clp = new Money(12, "CLP")
    _14clp = new Money(14, "CLP")
  }

  test("Equation of moneys") {
    assertEquals(_12clp, _12clp)
    assertEquals(_14clp, _14clp)
    assertEquals(_12clp, new Money(12, "CLP"))
    assertNotEquals(_14clp, _12clp)
    assert(!_12clp.equals(true))
  }
  test("Addition of moneys") {
    assertEquals(new Money(26, "CLP"), _12clp.add(_14clp)) // _12clp.+(_14clp)
  }
}
