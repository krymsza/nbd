/*
1.	(0.3 pts) Implement a Container class parametrized with type A.
Class constructor should accept a single private value of the given type.
The class should implement the following methods:
a.	getContent returning the stored value
b.	applyFunction accepting function A=>R and returning the result of application
  of this function to stored value

 */
case class zadanie1[A](private val value: A) {
  def getContent: A = value
  def applyFunction[R](function: A => R): zadanie1[R] = zadanie1(function(value))
}
object zadanie1 {
  def main(args: Array[String]): Unit = {
    val x = zadanie1(21)
    println(x.getContent)
  }
}