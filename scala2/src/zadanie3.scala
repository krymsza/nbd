/*
(0.2 pkt) Extend solution of task 3 with function applyFunction of type A=>R returning:
a.	for No: No
b.	for Yes: Yes(f(stored value))

 */
trait zadanie3[+A] {
  def apply[R](f: A => R): zadanie3[R]
}
case class Yes[A](value: A) extends zadanie3[A] {
  override def apply[R](function: A => R): zadanie3[R] = Yes(function(value))
}
case class No() extends zadanie3[Nothing]{
  override def apply[R](f: Nothing => R): zadanie3[R] = No()
}
object zadanie3 {
  def main(args: Array[String]): Unit = {
    val yes = Yes(4)
    val no = No()
    println(no)
    println(yes)
  }
}