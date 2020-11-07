
object secondPart {

  case class Elem(key: Option[String])

  def main(args: Array[String]): Unit = {
    //10.1
    val elements = Map("F" -> 5000.365, "J" -> 4548152.14, "P" -> None)
    def check(k: Option[String]) = {
      k match {
        case Some(k) => println("Value for " + k + " is: " + elements.get(k))
        case None => println("No value provided")
      }
    }
    val e = Elem(Some("J"))
    val e1 = Elem(None)
    check(e.key)
    check(e1.key)

    //10.2

  def printName(name: Option[String]) = {
    val n = name.getOrElse("No name provided")
    println(n)
  }
  printName(None)
  printName(e.key)
  }
}
