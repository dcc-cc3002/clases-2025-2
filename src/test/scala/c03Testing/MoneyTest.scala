package c03Testing

class MoneyTest extends munit.FunSuite {
  var _12clp: Money = null
  var _14clp: Money = null
  var _7usd: Money = null
  var _21usd: Money = null
  var _mb1: MoneyBag = null
  var _mb2: MoneyBag = null

  override def beforeEach(context: BeforeEach): Unit = {
    _12clp = new Money(12, "CLP")
    _14clp = new Money(14, "CLP")
    _7usd = new Money(7, "USD")
    _21usd = new Money(21, "USD")
    _mb1 = new MoneyBag(_12clp, _7usd)
    _mb2 = new MoneyBag(_14clp, _21usd)
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
  test("Equation of money bags") {
    assertEquals(_mb1, _mb1)
    assert(_mb1 != _12clp)
    assert(_12clp != _mb1)
    assertNotEquals(_mb1, _mb2)
    val _mb3 = new MoneyBag()
    _mb3.appendMoney(_7usd)
    _mb3.appendMoney(_12clp)
    assertEquals(_mb1, _mb3)
  }
  /*test("Addition of heterogeneous money") {
    val result: MoneyBag = _12clp.add(_7usd)
    val expected: MoneyBag = _mb1
    assertEquals(expected, result)
  }*/

}
