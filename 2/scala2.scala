
// 1
import scala.util.matching.Regex

object demo {
  def main(args: Array[String]) {
    val pattern = new Regex("monday|tuesday|wednesday|thursday|friday")
    val weekend = new Regex("saturday|sunday")
    val str = "sunday"

    pattern.findFirstIn(str) match {
      case Some(i) => println("work")
      case None => {
        weekend.findFirstIn(str) match {
          case Some(i) => println("weekend")
          case None => println("no such day")
        }
      }
    }
  }
}
//2
class BankAccount(val balance : Int=0) {
  var currentBalance = balance
  def this(){
    this(0)
  }
  def showDetails(){
    println(currentBalance)
  }
  def withdraw(x:Int){
    currentBalance = currentBalance - x
    println(currentBalance)
  }
  def deposit(x:Int): Unit ={
    currentBalance = currentBalance + x
  }
}
object MainObject{
  def main(args:Array[String]){
    var s = new BankAccount(110)
    s.showDetails()
    s.withdraw(10)
  }
}
//3
import scala.util.matching.Regex

class Person(val firstName:String, val lastName:String ) {
  override def toString(): String = s"$firstName $lastName"
}

object Person {
  def main(args: Array[String]): Unit = {

    var p0 = new Person("Bartosz", "Kowalski")
    var p1 = new Person("Ula", "Kowalska")
    var p2 = new Person("Zuzanna", "Filip")
    var p3 = new Person("user13412", "4")

    sayhello(p1)
    sayhello(p2)
    sayhello(p0)
    sayhello(p3)
  }

  def sayhello(x: Person) {
    var pattern = new Regex("[a-zA-Z].*?a$")
    var pattern2 = new Regex("[a-zA-Z].*?[^a0-9]$")
    var res = ""
    pattern.findFirstIn(x.firstName) match {
      case Some(i) => res = "Szanowna Pani " + x.firstName
      case None => {
        pattern2.findFirstIn(x.firstName) match {
          case Some(i) => res = "Szanowny Pan " + x.firstName
          case None => {
            res = "Witaj użytkowniku "+x.firstName
          }
        }
      }
    }
    if (x.lastName == "Kowalska")
      res = res + " Kowlaska"
    println(res)
  }
}
//4
object fun {
  def fun(x: Int, function: (Int) => Int): Int ={
    return function(function(function(x)))
  }
  def add(x:Int): Int ={
    return x+x;
  }

  def main(args: Array[String]): Unit = {
   println( fun(2, add));
  }
}
//5
trait Person {
  var firstName: String = ""
  var lastName: String = ""
  var taxToPay: Double = 0

  def Person(first:String, last:String, tax:Double){
    this.firstName = first
    this.lastName = last
    this.taxToPay = tax
  }
  def getData(): String ={
    return firstName + " " + lastName + " tax: "+ taxToPay + " "
  }
  def getFirstName(): String ={
    return  firstName
  }
  def getLastName(): String ={
    return  lastName
  }
  def getTaxToPay(): Double ={
    return  taxToPay
  }
}
trait Worker extends Person {
  var salary = 0.0
  override def Person(first: String, last: String, tax: Double): Unit = super.Person(first, last, tax)
  def setTaxToPay(): Unit ={
    taxToPay = 0.20*salary
  }
  def setSalary(s:Double): Unit ={
    this.salary=s
  }
  def getSalary(): Double ={
  return this.salary
  }

  override def getData(): String = super.getData() + " " + this.salary + " "
  override def getTaxToPay(): Double = {
    return taxToPay
  }
}
trait Student extends Person {
  taxToPay = 0.0
}
trait Teacher extends Worker {
  taxToPay = 0.1*salary
}

object MainObject{
  def main(args:Array[String]): Unit = {
  
    val w1 = new Worker() with Student
    w1.Person("K", "R", 67.0)
    w1.setSalary(400)
    println(w1.getData())

    val w2 = new Student() with Worker
    w2.setSalary(400)
    w2.Person("B", "M ", tax= 90)
    println(w2.getData())

  }
}
