import chapter3.CustomList
import chapter3.CustomList.{foldRight, foldLeft, reverse}

/*
Hard: Can you write foldLeft in terms of foldRight? How about the other
way around? Implementing foldRight via foldLeft is useful because it lets
us implement foldRight tail-recursively, which means it works even for
large lists without overflowing the stack.
*/

// foldLeft implemented using foldRight

def foldLeft2[A, B](as: CustomList[A], z: B)(f: (B, A) => B): B =
  foldRight(reverse(as), z)((a, b) => f(b, a))

foldLeft2(CustomList(1, 2, 3), 1)(_ - _) // -5

// foldRight implemented using foldLeft

def foldRight2[A, B](as: CustomList[A], z: B)(f: (A, B) => B): B =
  foldLeft(reverse(as), z)((b, a) => f(a, b))

foldRight2(CustomList(1, 2, 3), 1)(_ - _) // 1