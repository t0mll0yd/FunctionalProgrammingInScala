import chapter3.{CustomList, CustomNil}
import chapter3.CustomList.{foldRightTailRec, append}

/*
Hard: Write a function that concatenates a list of lists into
a single list. Its runtime should be linear in the total length
of all lists. Try to use functions we have already defined.
*/

def concatenate[A](xs: CustomList[CustomList[A]]): CustomList[A] = {
  foldRightTailRec(xs, CustomNil: CustomList[A])(append)
}

concatenate(CustomList(CustomList(1), CustomList(2))) // CustomList(1, 2)

/*
Using foldRight is faster than using foldLeft.
*/
