import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import org.specs2.specification.core.Fragments
import play.api.test._
import play.api.test.Helpers._

/**
  * add your integration spec here.
  * An integration test will fire up a whole play application in a real (or headless) browser
  */
@RunWith(classOf[JUnitRunner])
class codility extends Specification {
//  def multiplySteps(n: Int) = {
//    var i = 1L
//    var steps = 0
//    while (i <= n) {
//      steps += 1
//      i = i * 2
//    }
//    (steps, (n - (i / 2)).toInt)
//  }
//
//  def addSteps(remaining: Int) = {
//    var r = remaining
//    var steps = 0
//    while (r > 0) {
//      if (r % 2 == 1) steps += 1
//      r = r / 2
//    }
//    steps
//  }
//
//  def solution(n: Int): Int = {
//    val (mSteps, remaining) = multiplySteps(n)
//    mSteps + addSteps(remaining)
//  }

      case class Point2D(x:Int,y:Int)

      def coliniar(a:Point2D,b:Point2D,c:Point2D):Boolean = {
        val result = a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y) == 0
        if (result == true){
          println(a,b,c)
        }
        result
      }


      def solution(a:Array[Point2D]): Int = {
       val n = a.length
        var result = 0
        var x = 0
        for (i<- 0 until n)
          for (j<- i+1 until n){
            for (k <- j+1 until n){
              if (coliniar(a(i),a(j),a(k))) result+=1
            }
          }
       result
      }
  //  def solution(a: Array[Int]): Int = {
  //    var result = 0
  //    val n = a.length
  //    val diff= new Array[Long](n)
  //
  //    if (n < 3) return 0
  //
  //    for (i <- 1 until n) {
  //      diff(i) = a(i) - a(i-1)
  //    }
  //
  //    var add = 0
  //    for (i <- 1 until n - 1) {
  //      if (diff(i) == diff(i + 1)) {
  //        add += 1
  //      }
  //      else {
  //        add = 0
  //      }
  //      result += add
  //      if (result > 1000000000) return -1
  //    }
  //    result
  //  }


  "Application" should {
    "check" in {
//            solution(Array(Point2D(0,0),Point2D(1,4),Point2D(2,6),Point2D(2,8),Point2D(2,3))) shouldEqual 2
      //      val l=Array.fill[Point2D](500)(Point2D(2,4))
      //      solution(List(-1, 1, 3, 3, 3, 2, 1, 0).toArray) shouldEqual 5
            solution(23) shouldEqual 5
//      solution(29) shouldEqual 64
    }
  }
}
