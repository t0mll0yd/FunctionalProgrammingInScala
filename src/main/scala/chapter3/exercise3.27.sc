import chapter3.{Branch, Leaf, Tree}

/*
Write a function depth that returns the maximum path length from
the root of a tree to any leaf.
*/

def depth[A](tree: Tree[A]): Int = tree match {
  case Branch(l, r) => (depth(l) max depth(r)) + 1
  case Leaf(_) => 0
}

depth(Leaf(1)) // 0
depth(Branch(Leaf(1), Leaf(2))) // 1
depth(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) // 2