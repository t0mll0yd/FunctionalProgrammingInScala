import chapter3.{Branch, Leaf, Tree}

/*
Generalize size, maximum, depth, and map, writing a new function fold
that abstracts over their similarities. Reimplement them in terms of this
more general function. Can you draw an analogy between this fold
function and the left and right folds for List?
*/

def fold[A, B](tree: Tree[A])(f: A => B)(g: (B, B) => B): B = tree match {
  case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  case Leaf(v) => f(v)
}

def size[A](tree: Tree[A]) = fold(tree)(_ => 1)(_ + _ + 1)

size(Branch(Leaf(1), Leaf(2))) // 3
size(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) // 5

def maximum(tree: Tree[Int]) = fold(tree)(a => a)(_ max _)

maximum(Branch(Leaf(2), Leaf(3))) // 3
maximum(Branch(Branch(Leaf(2), Leaf(3)), Leaf(5))) // 5

def depth[A](tree: Tree[A]) = fold(tree)(_ => 0)((a, b) => (a max b) + 1)

depth(Leaf(1)) // 0
depth(Branch(Leaf(1), Leaf(2))) // 1
depth(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) // 2

def map[A, B](tree: Tree[A])(f: A => B) = fold(tree)(a => Leaf(f(a)): Tree[B])(Branch(_, _))

map(Branch(Leaf(1), Leaf(2)))(_ * 2) // Branch(Leaf(2),Leaf(4))