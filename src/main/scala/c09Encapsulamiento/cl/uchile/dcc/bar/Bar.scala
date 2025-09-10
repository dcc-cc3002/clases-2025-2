package c09Encapsulamiento.cl.uchile.dcc.bar

package cl.uchile.dcc.bar

import c09Encapsulamiento.cl.uchile.dcc.Foo

class Bar extends Foo:
  private val isBar = true
  def doBar(b: Bar): Unit =
    if b.isFoo then ???
