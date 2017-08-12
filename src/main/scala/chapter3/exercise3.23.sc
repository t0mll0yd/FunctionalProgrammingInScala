import chapter3.{CustomCons, CustomList, CustomNil}
import chapter3.CustomList.reverse

/*
Generalize the function you just wrote so that it’s not
specific to integers or addition. Name your generalized function zipWith.
*/

def zipWith[A, B, C](xs1: CustomList[A], xs2: CustomList[B])(combine: (A, B) => C): CustomList[C] = {
  def loop(ys1: CustomList[A], ys2: CustomList[B], acc: CustomList[C]): CustomList[C] = (ys1, ys2) match {
    case (CustomCons(h1, t1), CustomCons(h2, t2)) => loop(t1, t2, CustomCons(combine(h1, h2), acc))
    case _ => acc
  }

  reverse(loop(xs1, xs2, CustomNil))
}

/*
Not particularly happy with this implementation, feels like there should
be a way to reuse functions we have already written.
*/

def zip[A, B](xs1: CustomList[A], xs2: CustomList[B]): CustomList[(A, B)] = zipWith(xs1, xs2)((_, _))

zip(CustomList(1, 2, 3), CustomList("a", "b", "c")) // CustomList((1, "a"), (2, "b"), (3, "c"))

def zipByMultiplying(xs1: CustomList[Int], xs2: CustomList[Int]): CustomList[Int] = zipWith(xs1, xs2)(_ * _)

zipByMultiplying(CustomList(1, 2, 3, 4), CustomList(2, 3, 4)) // CustomList(2, 6, 12)