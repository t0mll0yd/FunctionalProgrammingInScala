import chapter3.{CustomCons, CustomList, CustomNil}

/*
Hard: As an example, implement hasSubsequence for checking whether a List contains
another List as a subsequence. For instance, List(1,2,3,4) would have List(1,2), List(2,3),
and List(4) as subsequences, among others. You may have some difficulty finding a
concise purely functional implementation that is also efficient. That’s okay. Implement
the function however comes most naturally. We’ll return to this implementation in chapter 5
and hopefully improve on it. Note: Any two values x and y can be compared for equality in
Scala using the expression x == y.
*/

def isSubsequenceFromStart[A](sup: CustomList[A], sub: CustomList[A]): Boolean = {
  def loop(sup: CustomList[A], sub: CustomList[A], acc: Boolean): Boolean = (sup, sub) match {
    case (_, CustomNil) => true
    case (CustomNil, _) => false
    case (CustomCons(h1, t1), CustomCons(h2, t2)) => loop(t1, t2, h1 == h2 && acc)
  }

  loop(sup, sub, acc = true)
}

def hasSubsequence[A](sup: CustomList[A], sub: CustomList[A]): Boolean = {
  if (isSubsequenceFromStart(sup, sub)) true
  else sup match {
    case CustomNil => false
    case CustomCons(_, t) => hasSubsequence(t, sub)
  }
}

hasSubsequence(CustomNil, CustomNil) // true
hasSubsequence(CustomList(1), CustomNil) // true
hasSubsequence(CustomNil, CustomList(1)) // false
hasSubsequence(CustomList(1, 2, 3, 4, 5), CustomList(3)) // true