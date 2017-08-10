import chapter3.{CustomCons, CustomList, CustomNil}

/*
Implement the function tail for removing the first element of a List.
Note that the function takes constant time. What are different choices
you could make in your implementation if the List is Nil? We’ll return
to this question in the next chapter.
*/

// Blow up on empty list
def tail[A](as: CustomList[A]): CustomList[A] = as match {
  case CustomCons(_, xs) => xs
  case CustomNil => throw new Exception("Cannot get tail of empty list")
}

tail(CustomList(1)) // CustomNil
tail(CustomList(1, 2)) // CustomList(2)
// tail(CustomList()) would blow up

// Return Option on empty list
def tail2[A](as: CustomList[A]): Option[CustomList[A]] = as match {
  case CustomCons(_, xs) => Some(xs)
  case CustomNil => None
}

tail2(CustomList(1)) // Some(CustomNil)
tail2(CustomList(1, 2)) // Some(CustomList(2))
tail2(CustomList()) // None