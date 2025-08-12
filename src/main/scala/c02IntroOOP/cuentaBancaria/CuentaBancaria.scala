package c02IntroOOP.cuentaBancaria

/** Implementación concreta de una cuenta bancaria.
  *
  * Esta clase mantiene un saldo interno y permite modificarlo mediante
  * las operaciones definidas en [[ICuentaBancaria]].
  *
  * @param saldo saldo inicial de la cuenta.
  */
class CuentaBancaria(var saldo: Int) extends ICuentaBancaria {

  def obtenerSaldo(): Int = saldo

  /** Además, si el monto es mayor que el saldo, no se modifica el valor de `saldo`.
    */
  def retirar(monto: Int): Boolean =
    if (monto <= saldo) {
      saldo -= monto
      true
    } else {
      false
    }

  def depositar(monto: Int): Unit =
    saldo += monto
}
