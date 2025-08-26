package c03Testing

class Money(value: Int, currency: String) {
  def getValue(): Int = value
  def getCurrency(): String = currency

  def add(other: Money): Money =
    // if (getCurrency() == other.getCurrency())
    new Money(getValue() + other.getValue(), getCurrency())
  // else
  //  new MoneyBag(Set(this, other))

  def foo = println("hola")

  override def toString(): String = s"Money($value, $currency)"

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Money]) {
      val otherMoney: Money = other.asInstanceOf[Money]
      getValue() == otherMoney.getValue() &&
      getCurrency() == otherMoney.getCurrency()
    } else false
  }
}
