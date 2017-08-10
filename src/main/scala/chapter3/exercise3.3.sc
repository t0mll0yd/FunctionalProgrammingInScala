import chapter3.{CustomCons, CustomList, CustomNil}

/*
Using the same idea, implement the function setHead for
replacing the first element of a List with a different value.
*/

def setHead[A](as: CustomList[A], h: A): CustomList[A] = as match {
  case CustomCons(_, xs) => CustomCons(h, xs)
  case CustomNil => CustomList(h)
}

setHead(CustomList(1, 2, 3), 2) // CustomList(2, 2, 3)
setHead(CustomNil, 2) // CustomList(2)