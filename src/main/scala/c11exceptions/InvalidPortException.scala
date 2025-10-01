package c11exceptions

class InvalidPortException(msg: String) extends Exception(msg)

object Main:
  def validatePort(port: Int): Unit =
    if port < 0 || port > 65535 then
      throw new InvalidPortException(s"Invalid port: $port")
    throw new Exception("Otro tipo de excepcion")

  def foo() =
    try validatePort(70000)
    finally
      println("Finally siempre se ejecuta")
      throw new Exception("Excepcion en finally")

  def main(args: Array[String]): Unit =
    foo()
