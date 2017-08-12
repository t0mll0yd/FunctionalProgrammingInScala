import chapter3.{Branch, Leaf, Tree}

/*
Write a function size that counts the number of nodes
(leaves and branches) in a tree.
*/


// Works but not tail recursive.
def size[A](tree: Tree[A]): Int = tree match {
  case Leaf(_) => 1
  case Branch(l, r) => size(l) + size(r) + 1
}

size(Branch(Leaf(1), Leaf(2))) // 3
size(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) // 5
