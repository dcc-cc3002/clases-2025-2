package c12polymorphism

class Par[I, D](i: I, d: D) {
  def swap: Par[D, I] = Par[D, I](d, i)
}
