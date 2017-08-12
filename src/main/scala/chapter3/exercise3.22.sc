import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.reverse

/*
Write a function that accepts two lists and constructs a new
list by adding corresponding elements. For example, List(1,2,3)
and List(4,5,6) become List(5,7,9).
*/

def zipIntLists(xs1: CustomList[Int], xs2: CustomList[Int]): CustomList[Int] = {
  def loop(ys1: CustomList[Int], ys2: CustomList[Int], acc: CustomList[Int]): CustomList[Int] = (ys1, ys2) match {
    case (CustomCons(h1, t1), CustomCons(h2, t2)) => loop(t1, t2, CustomCons(h1 + h2, acc))
    case _ => acc
  }

  reverse(loop(xs1, xs2, CustomNil))
}

/*
It feels like there should be a neater way to write this function,
maybe using functions we've already written, but I can't quite see it.
*/

zipIntLists(CustomList(1, 2, 3), CustomList(4, 5, 6)) // CustomList(5, 7, 9)

zipIntLists(CustomList(1, 2, 3, 4), CustomList(4, 5, 6)) // CustomList(5, 7, 9)