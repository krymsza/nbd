  /*
  1.	Create a 7 element list with names of days of the week. Create a function returning a string with comma-separated list elements using:
  a.	for loop
  b.	for loop, the string should contain only days with names starting with “S”
  c.	while loop

   */
  object first {
    val days: List[String] = List("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")

    def main(args: Array[String]) {

      //1a
      for (i <- days)
        print(i + ", ")
      println()

      //1b
      for (i <- days if i.startsWith("s"))
        print(i + ", ")
      println()

      //1c
      var i=0
      while (i<days.length){
        print(days(i)+ ", ")
        i = i + 1
      }
      println()

      //2a
      println(funA("", 0))
      def funA(result: String, i: Int): String = {
        if(i < days.length) return funA(result.concat(days(i)+ ", "), i+1)
        else return result
      }

      //2b
      println(funB("", days.length-1))
      def funB(result: String, i: Int): String = {
        if(i >= 0) return funB(result.concat(days(i)+ ", "), i-1)
        else return result
      }

      //3
      def fun3(d: List[String], index: Int, result: String): Unit = {
        if (d.length == index) {
          println(result)
        } else {
          fun3(d, index + 1, result + d(index)++ ", ")
        }
      }
      fun3(days,0,"")

      //4a
      println(days.foldLeft("")((a, b) => a + b + ", "))

      //4b
      println(days.foldRight("")((a, b) => a + ", "+ b))

      //4c
      println(days.foldLeft("") { (z, f) =>
        if (f.startsWith("s")) {
          if(!z.startsWith("s"))
            f+","
          else z+f+", "
        } else f
      })

      //5
      val m1 = Map("tea"-> 2.00, "pen"->5.00, "phone"->1500.00, "water"-> 0.60)
      var m2 = m1
      println(m2)
      var kk = 0.0
      m2.values.foreach(k => kk = 0.9*k)
      println(m2)

      //6
      val lista: List[Int] = List(1, 2, 3, 4, 5)
      println(lista map (n => n+1))

      //7
      def fun7(lista: List[Int]): List[Int] = {
        return lista map (n => if (n < 0)  -n else  n)
      }
      println(fun7(List(-7, 6, -8, 0)))

      //8
      fun8(("Sugar" , 25, 'k'))
      def fun8(t: (String, Int, Char)): Unit ={
        println(t._1 + " " + t._2 + " " + t._3)
      }
      //9
      println(fun9(List(0, 6, 7, 0, 4, 3)))
      def fun9(list: List[Int]): List[Int] = {
        return list.filter(n => n != 0)
      }

    }
}
