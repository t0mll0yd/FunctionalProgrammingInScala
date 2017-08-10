import chapter3.CustomList
import CustomList.foldRight

/*
Compute the length of a list using foldRight.
*/

def length[A](as: CustomList[A]): Int = foldRight(as, 0)((_, length) => length + 1)

length(CustomList()) // 0
length(CustomList(1)) // 1
length(CustomList(1, 2, 3, 4, 5)) // 5