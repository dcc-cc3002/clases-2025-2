package c09Encapsulamiento

package cl.uchile.dcc

class Foo:
  protected val isFoo = true
  def doFoo(f: Foo): Unit =
    if f.isFoo then ???



