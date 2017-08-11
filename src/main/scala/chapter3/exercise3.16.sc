import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.foldRightTailRec

/*
Write a function that transforms a list of integers by adding 1
to each element. (Reminder: this should be a pure function that
returns a new List!)
*/

def add1(as: CustomList[Int]): CustomList[Int] = {
  foldRightTailRec(as, CustomNil: CustomList[Int])((a, b) => CustomCons(a + 1, b))
}

add1(CustomList(1, 2, 3)) // List(2, 3, 4)