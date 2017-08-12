import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.foldRightTailRec

/*
Write a function filter that removes elements from a list unless
they satisfy a given predicate. Use it to remove all odd numbers
from a List[Int].
*/

def filter[A](as: CustomList[A])(f: A => Boolean): CustomList[A] = {
  foldRightTailRec(as, CustomNil: CustomList[A])((a, b) => {
    if (f(a)) CustomCons(a, b)
    else b
  })
}

def removeOddNumbers(as: CustomList[Int]): CustomList[Int] = filter(as)(_ % 2 == 0)

removeOddNumbers(CustomList(1, 2, 3, 4)) // CustomList(2, 4)