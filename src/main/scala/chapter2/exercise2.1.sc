import scala.annotation.tailrec

def fib(n: Int): Int = {

  @tailrec
  def loop(n: Int, acc1: Int, acc2: Int): Int = {
    if (n < 1) acc1
    else loop(n - 1, acc2, acc1 + acc2)
  }

  loop(n, 0, 1)
}

fib(0)  // 0
fib(1)  // 1
fib(2)  // 1
fib(3)  // 2
fib(20) // 6765