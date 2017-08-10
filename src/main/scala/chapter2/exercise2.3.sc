def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
  (a: A) => (b: B) => f(a, b)
}

val curriedAdd = curry[Int, Int, Int](_ + _)

curriedAdd(1)(2) // 3