/*
4.	(0.3 pkt) extend solution of task 3 with function getOrElse parametrized with type and returning:
a.	for No – parameter of getOrElse
b.	for Yes – content of Yes

 */
trait zadanie4[+A] {
  def apply[R](f: A => R): zadanie4[R]
  def getOrElse[R >: A](defaultValue: => R): R
}
case class Yes4[A](value: A) extends zadanie4[A] {
  override def apply[R](func: A => R): zadanie4[R] = Yes4(func(value))
  override def getOrElse[R >: A](defaultValue: => R): R = value
}
case class No4() extends zadanie4[Nothing]{
  override def apply[R](func: Nothing => R): zadanie4[R] = No4()
  override def getOrElse[R >: Nothing](defaultValue: => R): R = defaultValue
}
object zad4 {
  def main(args: Array[String]): Unit = {
    val yes = Yes4(4)
    val no = No4()

    println(yes.getOrElse(4))
    println(no.getOrElse(5))


  }
}