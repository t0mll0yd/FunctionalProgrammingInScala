import chapter3.{CustomCons, CustomList, CustomNil}
import CustomList.sum

/*
What will be the result of the following match expression?
*/

val result = CustomList(1,2,3,4,5) match {
  case CustomCons(x, CustomCons(2, CustomCons(4, _))) => x // Won't match because third element isn't 4
  case CustomNil => 42 // Won't match because isn't Nil
  case CustomCons(x, CustomCons(y, CustomCons(3, CustomCons(4, _)))) => x + y // Will match => returns 3
  case CustomCons(h, t) => h + sum(t)
  case _ => 101
}

result == 3 // true