import chapter3.{Branch, Leaf, Tree}

/*
Write a function map, analogous to the method of the same name
on List, that modifies each element in a tree with a given function.
*/

def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
  case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  case Leaf(v) => Leaf(f(v))
}

map(Branch(Leaf(1), Leaf(2)))(_ * 2) // Branch(Leaf(2),Leaf(4))