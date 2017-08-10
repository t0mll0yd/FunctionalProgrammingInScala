/*
Implement the higher-order function that composes two functions.
*/

def compose[A,B,C](f: B => C, g: A => B): A => C = {
  (a: A) => f(g(a))
}

def add1: Int => Int = _ + 1

def multiplyBy2: Int => Int = _ * 2

def add1ThenMultiplyBy2 = compose(multiplyBy2, add1)
def multiplyBy2ThenAdd1 = compose(add1, multiplyBy2)

add1ThenMultiplyBy2(2) // 6
multiplyBy2ThenAdd1(2) // 5