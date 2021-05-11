
object MinimumTrianglePath extends App {

  final case class Triangle(value: Int, left: Option[Triangle] = None, right: Option[Triangle] = None)

  object Triangle {
    def apply(value: Int, left: Triangle, right: Triangle): Triangle = {
      new Triangle(value, Some(left), Some(right))
    }
  }

  val nodeTriangle =
    Triangle(7,
      Triangle(6,
        Triangle(3,
          Triangle(11),
          Triangle(2)
        ),
        Triangle(8,
          Triangle(2),
          Triangle(10)
        )
      ),
      Triangle(3,
        Triangle(8,
          Triangle(2),
          Triangle(10)
        ),
        Triangle(5,
          Triangle(10),
          Triangle(9)
        )
      )
    )

  def minPath(triangle: Triangle): List[Int] = triangle match {
    case Triangle(value, Some(left), Some(right)) =>
      val leftMinPath = minPath(left)
      val rightMinPath = minPath(right)

      value :: (if (leftMinPath.sum < rightMinPath.sum) leftMinPath else rightMinPath)
    case Triangle(value, _, _) => List(value)
  }


//    val input = List("7", "6 3", "3 8 5", "11 2 10 9")
//  val input = List("2", "3 4", "6 5 7", "4 1 8 3")


  def buildTriangle(level: Int, lines: List[List[Int]]): Option[Triangle] = lines match {
    case head :: tail =>
      Some(Triangle(
        head(level),
        left = buildTriangle(level, tail),
        right = buildTriangle(level + 1, tail)
      ))
    case _ => None
  }

  val input = io.Source.stdin.getLines.toList
  val triangle = input.map(i => i.trim.split("\\s+").toList.map(_.toInt))

  println(minPath(buildTriangle(0, triangle).get))
  println("DONE")

}