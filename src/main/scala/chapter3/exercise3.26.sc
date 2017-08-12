import chapter3.{Branch, Leaf, Tree}

/*
Write a function maximum that returns the maximum element in a
Tree[Int]. (Note: In Scala, you can use x.max(y) or x max y to
compute the maximum of two integers x and y.)
*/

def maximum(tree: Tree[Int]): Int = tree match {
  case Branch(l, r) => maximum(l) max maximum(r)
  case Leaf(v) => v
}

maximum(Branch(Leaf(2), Leaf(3))) // 3
maximum(Branch(Branch(Leaf(2), Leaf(3)), Leaf(5))) // 5