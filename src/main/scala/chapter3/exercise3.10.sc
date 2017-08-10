import chapter3.{CustomCons, CustomList, CustomNil}
import CustomList.foldRight

import scala.annotation.tailrec

/*
Our implementation of foldRight is not tail-recursive and will
result in a StackOverflowError for large lists (we say it’s not
stack-safe). Convince yourself that this is the case, and then
write another general list-recursion function, foldLeft, that is
tail-recursive, using the techniques we discussed in the previous chapter.
*/

@tailrec
def foldLeft[A, B](as: CustomList[A], z: B)(f: (B, A) => B): B = as match {
  case CustomNil => z
  case CustomCons(x, xs) => foldLeft(xs, f(z, x))(f)
}

foldLeft(CustomList(1, 2, 3), 0)(_ - _) // ((0 - 1) - 2) - 3 = -6
foldRight(CustomList(1, 2, 3), 0)(_ - _) // 1 - (2 - (3 - 0)) = 2
