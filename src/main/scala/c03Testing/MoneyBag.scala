package c03Testing
import scala.collection.mutable.Map

class MoneyBag {
  val moneys: Map[String, Money] = Map()
  def this(s: Set[Money]) = {
    this()
    for (money <- s) { // for money in s:
      appendMoney(money)
    }
  }
  def this(m1: Money, m2: Money) = {
    this(Set(m1, m2))
  }
  def appendMoney(m: Money): Unit = {
    // m.getCurrency()
    // m.getValue()
    // ver si tenemos ya un Money para esa divisa
    if (moneys.isDefinedAt(m.getCurrency())) {
      // - Si ya tenemos algo, tenemos que actualizar el valor con el valor nuevo
      val moneyActual: Money = moneys.get(m.getCurrency()).get
      moneys += (m.getCurrency() -> moneyActual.add(m))
    } else {
      // - Si no, extendemos el diccionario (Map) con el nuevo valor
      moneys += (m.getCurrency() -> m)
    }
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[MoneyBag]) {
      val mb = obj.asInstanceOf[MoneyBag]
      moneys.equals(mb.moneys)
    } else false
  }
}
