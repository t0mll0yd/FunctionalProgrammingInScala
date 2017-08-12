import chapter3.{CustomList, CustomNil}
import chapter3.CustomList.{foldRightTailRec, append}

/*
Write a function flatMap that works like map except that the function
given will return a list instead of a single result, and that list should
be inserted into the final resulting list.
*/

def flatMap[A,B](as: CustomList[A])(f: A => CustomList[B]): CustomList[B] = {
  foldRightTailRec(as, CustomNil: CustomList[B])((a, b) => append(f(a), b))
}

flatMap(CustomList(1, 2, 3))(i => CustomList(i,i)) // CustomList(1, 1, 2, 2, 3, 3