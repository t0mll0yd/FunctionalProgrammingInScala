import chapter3.{CustomCons, CustomList, CustomNil}

/*
Not everything works out so nicely. Implement a function,
init, that returns a List consisting of all but the last element
of a List. So, given List(1,2,3,4), init will return List(1,2,3).
Why can’t this function be implemented in constant time like tail?
*/

def init[A](as: CustomList[A]): CustomList[A] = as match {
  case CustomCons(_, CustomNil) => CustomNil
  case CustomCons(x, xs) => CustomCons(x, init(xs))
  case CustomNil => throw new Exception("Tried to call init on empty List")
}

init(CustomList(1, 2, 3)) // CustomList(1, 2)
init(CustomList(1)) // CustomNil
// init(CustomList()) would blow up

/*
'init' cannot be implemented in constant time because we have
to copy all of the previous Cons objects, whereas 'tail'
uses data sharing.
*/