import scala.annotation.tailrec

// Curried for better type inference
@tailrec
def isSorted[A](as: Array[A])(ordered: (A,A) => Boolean): Boolean = {
  if (as.length < 2) true
  else if (ordered(as(0), as(1))) isSorted(as.tail)(ordered)
  else false
}

isSorted(Array(0, 1, 2))(_ < _) // true
isSorted(Array(0, 2, 1))(_ < _) // false

isSorted(Array("hi", "hello", "greetings"))(_.length < _.length) // true
isSorted(Array("hi", "greetings", "hello"))(_.length < _.length) // false