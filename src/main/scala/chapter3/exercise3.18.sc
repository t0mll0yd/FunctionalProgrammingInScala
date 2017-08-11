import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.foldRightTailRec

/*
Write a function map that generalizes modifying each element
in a list while maintaining the structure of the list.
*/

def map[A,B](as: CustomList[A])(f: A => B): CustomList[B] = {
  foldRightTailRec(as, CustomNil: CustomList[B])((a, b) => CustomCons(f(a), b))
}

// Rewriting example functions using the map function

def add1(as: CustomList[Int]): CustomList[Int] = map(as)(_ + 1)

add1(CustomList(1, 2, 3)) // List(2, 3, 4)

def toString(as: CustomList[Double]): CustomList[String] = map(as)(_.toString)

toString(CustomList(1, 2, 3)) // List("1", "2", "3")