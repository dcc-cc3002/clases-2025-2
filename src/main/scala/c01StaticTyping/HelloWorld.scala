package c01StaticTyping

import scala.io.StdIn.*


object HelloWorld {
  def main(args: Array[String]) = {
    println("Please enter your name:")
    val name = readLine()
    println("Please enter your age:")
    val age = readLine()
    println(s"Hello, $age you age is $name!")
  }
}


@main
def main2() = {
  println("hello world 2")
}
