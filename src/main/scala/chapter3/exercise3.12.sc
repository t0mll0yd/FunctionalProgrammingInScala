import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.foldLeft

/*
Write a function that returns the reverse of a list (given List(1,2,3)
it returns List(3,2,1)). See if you can write it using a fold.
*/

def reverse[A](as: CustomList[A]): CustomList[A] =
  foldLeft(as, CustomNil: CustomList[A])((b, a) => CustomCons(a, b))

reverse(CustomList(1, 2, 3)) // CustomList(3, 2, 1)