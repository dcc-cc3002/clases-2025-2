package c02IntroOOP.cuentaBancaria

/** Representa la interfaz de una cuenta bancaria.
  *
  * Esta interfaz define las operaciones básicas que puede realizar una cuenta bancaria,
  * como consultar el saldo, retirar fondos y depositar dinero.
  * Las implementaciones concretas deben definir la lógica para mantener y modificar
  * el estado de la cuenta.
  */
trait ICuentaBancaria {

  /** Obtiene el saldo actual de la cuenta.
    *
    * @return el saldo disponible como un valor entero.
    */
  def obtenerSaldo(): Int

  /** Retira un monto específico de la cuenta si hay saldo suficiente.
    *
    * @param monto cantidad de dinero a retirar.
    * @return `true` si el retiro fue exitoso, `false` si no hay fondos suficientes.
    */
  def retirar(monto: Int): Boolean

  /** Deposita un monto específico en la cuenta.
    *
    * @param monto cantidad de dinero a depositar.
    */
  def depositar(monto: Int): Unit
}
