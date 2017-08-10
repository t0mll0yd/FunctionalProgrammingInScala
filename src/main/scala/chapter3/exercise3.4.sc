import chapter3.{CustomCons, CustomList, CustomNil}

/*
Generalize tail to the function drop, which removes the first n
elements from a list. Note that this function takes time proportional
only to the number of elements being dropped—we don’t need
to make a copy of the entire List.
*/

def drop[A](as: CustomList[A], n: Int): CustomList[A] = as match {
  case CustomCons(_, xs) =>
    if (n < 1) as
    else drop(xs, n - 1)
  case CustomNil => CustomNil
}

drop(CustomNil, 1) // CustomNil
drop(CustomList(1, 2, 3), 1) // CustomList(2, 3)
drop(CustomList(1, 2, 3), 4) // CustomNil