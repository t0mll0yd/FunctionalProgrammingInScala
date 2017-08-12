package chapter3

import scala.annotation.tailrec

sealed trait CustomList[+A]

case object CustomNil extends CustomList[Nothing]
case class CustomCons[+A](head: A, tail: CustomList[A]) extends CustomList[A]

object CustomList {
  def foldRight[A, B](as: CustomList[A], z: B)(f: (A, B) => B): B = as match {
    case CustomCons(x, xs) => f(x, foldRight(xs, z)(f))
    case CustomNil => z
  }

  def sum(ints: CustomList[Int]): Int = ints match {
    case CustomCons(x, xs) => x + sum(xs)
    case CustomNil => 0
  }

  def apply[A](as: A*): CustomList[A] = {
    if (as.isEmpty) CustomNil
    else CustomCons(as.head, apply(as.tail: _*))
  }

  // See exercise 3.9
  def length[A](as: CustomList[A]): Int = foldRight(as, 0)((_, length) => length + 1)

  // See exercise 3.10
  @tailrec
  def foldLeft[A, B](as: CustomList[A], z: B)(f: (B, A) => B): B = as match {
    case CustomNil => z
    case CustomCons(x, xs) => foldLeft(xs, f(z, x))(f)
  }

  // See exercise 3.12
  def reverse[A](as: CustomList[A]): CustomList[A] =
  foldLeft(as, CustomNil: CustomList[A])((b, a) => CustomCons(a, b))

  // See exercise 3.13
  def foldRightTailRec[A, B](as: CustomList[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(as), z)((b, a) => f(a, b))

  // See exercise 3.14
  def append[A](as: CustomList[A], xs: CustomList[A]): CustomList[A] =
    foldRightTailRec(as, xs)(CustomCons(_, _))

  // See exercise 3.20
  def flatMap[A,B](as: CustomList[A])(f: A => CustomList[B]): CustomList[B] = {
    foldRightTailRec(as, CustomNil: CustomList[B])((a, b) => append(f(a), b))
  }

  // See exercise 3.23
  def zipWith[A, B, C](xs1: CustomList[A], xs2: CustomList[B])(combine: (A, B) => C): CustomList[C] = {
    def loop(ys1: CustomList[A], ys2: CustomList[B], acc: CustomList[C]): CustomList[C] = (ys1, ys2) match {
      case (CustomCons(h1, t1), CustomCons(h2, t2)) => loop(t1, t2, CustomCons(combine(h1, h2), acc))
      case _ => acc
    }

    reverse(loop(xs1, xs2, CustomNil))
  }
}