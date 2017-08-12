import chapter3.{CustomCons, CustomList, CustomNil}

/*
Implement dropWhile, which removes elements from the
List prefix as long as they match a predicate.
*/

def dropWhile[A](l: CustomList[A], p: A => Boolean): CustomList[A] = l match {
  case CustomCons(x, xs) =>
    if (!p(x)) l
    else dropWhile(xs, p)
  case CustomNil => CustomNil
}

dropWhile[Int](CustomNil, _ => true) // CustomNil
dropWhile(CustomList(1, 2, 3), (a: Int) => a % 2 == 1) // CustomList(2, 3)
dropWhile(CustomList(1, 2, 3), (a: Int) => a % 2 == 0) // CustomList(1, 2, 3)