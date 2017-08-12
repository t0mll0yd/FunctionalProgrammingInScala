import chapter3.{CustomList, CustomNil}
import chapter3.CustomList.flatMap

/*
Use flatMap to implement filter.
*/

def filter[A](as: CustomList[A])(f: A => Boolean): CustomList[A] = {
  flatMap(as)(a => if (f(a)) CustomList(a) else CustomNil)
}

def removeOddNumbers(as: CustomList[Int]): CustomList[Int] = filter(as)(_ % 2 == 0)

removeOddNumbers(CustomList(1, 2, 3, 4)) // CustomList(2, 4)