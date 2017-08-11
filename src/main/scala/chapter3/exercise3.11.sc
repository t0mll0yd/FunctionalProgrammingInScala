import chapter3.CustomList
import chapter3.CustomList.foldLeft

/*
Write sum, product, and a function to compute the length of a list using foldLeft.
*/

// Sum

def sum(as: CustomList[Int]): Int = foldLeft(as, 0)(_ + _)

sum(CustomList(2, 3, 4)) // 9

// Product

def product(as: CustomList[Int]): Int = foldLeft(as, 1)(_ * _)

product(CustomList(2, 3, 4)) // 24

// Length

def length[A](as: CustomList[A]): Int = foldLeft(as, 0)((length, _) => length + 1)

length(CustomList()) // 0
length(CustomList(1)) // 1
length(CustomList(1, 2, 3, 4, 5)) // 5