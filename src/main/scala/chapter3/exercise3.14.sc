import chapter3.{CustomCons, CustomList}
import chapter3.CustomList.foldRightTailRec

/*
Implement append in terms of either foldLeft or foldRight.
*/

def append[A](as: CustomList[A], xs: CustomList[A]): CustomList[A] =
  foldRightTailRec(as, xs)(CustomCons(_, _))

append(CustomList(1, 2, 3), CustomList(4, 5)) // CustomList(1, 2, 3, 4, 5)