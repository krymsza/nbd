/*
(0.2 pkt) Implement trait Maybe parametrized with type A and two classes extending it –
  class No extending Maybe[Nothing] and class Yes parametrized with type A and storing a single value of a given type.
   Create objects of both classes. Check if they both are subtypes of Maybe[_]
    (use isInstanceOf method parametrized with checked type)
 */

trait zadanie2[A]
case class No2() extends zadanie2[Nothing]
case class Yes2[A](value: A) extends zadanie2[A]

object zadanie2 {
  def main(args: Array[String]): Unit = {
    val no = No2()
    val yes = Yes2(4)
    println(no.isInstanceOf[zadanie2[_]])
    println(yes.isInstanceOf[zadanie2[_]])
  }
}