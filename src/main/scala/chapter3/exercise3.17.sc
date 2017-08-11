import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.foldRightTailRec

/*
Write a function that turns each value in a List[Double] into
a String. You can use the expression d.toString to convert some
d: Double to a String.
*/

def toString(as: CustomList[Double]): CustomList[String] = {
  foldRightTailRec(as, CustomNil: CustomList[String])((a, b) => CustomCons(a.toString, b))
}

toString(CustomList(1, 2, 3)) // List("1", "2", "3")