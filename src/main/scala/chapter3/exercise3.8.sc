import chapter3.{CustomCons, CustomList, CustomNil}
import CustomList.foldRight

/*
See what happens when you pass Nil and Cons themselves to
foldRight, like this: foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)).
What do you think this says about the relationship between foldRight
and the data constructors of List?
*/

foldRight(CustomList(1, 2, 3), CustomNil: CustomList[Int])(CustomCons(_, _)) // List(1, 2, 3)

/*
Folding over a list using Nil as the default and the constructor
as the combining function, you get back the original list.
*/
