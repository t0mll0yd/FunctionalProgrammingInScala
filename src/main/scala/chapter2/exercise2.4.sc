def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
  (a: A, b: B) => f(a)(b)
}

def curriedAdd = (a: Int) => (b: Int) => a + b

val add = uncurry(curriedAdd)

add(1, 2) // 3