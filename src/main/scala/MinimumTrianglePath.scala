import scala.util.Try

final case class Triangle(value: Int, left: Option[Triangle], right: Option[Triangle])

object MinimumTrianglePath {
  def buildTriangle(position: Int, nodes: List[List[Int]]): Option[Triangle] = nodes match {
    case head :: tail if head.lift(position).isDefined =>
      Some(Triangle(
        head(position),
        left = buildTriangle(position, tail),
        right = buildTriangle(position + 1, tail)
      ))
    case _ => None
  }

  def findMinPath(triangle: Triangle): List[Int] = triangle match {
    case Triangle(value, Some(left), Some(right)) =>
      val leftMinPath = findMinPath(left)
      val rightMinPath = findMinPath(right)

      value :: (if (leftMinPath.sum < rightMinPath.sum) leftMinPath else rightMinPath)
    case Triangle(value, _, _) => List(value)
  }

  def main(args: Array[String]): Unit = {
    val lines: List[String] = io.Source.stdin.getLines.toList

    val nodes = Try{
      lines.map(_.trim.split("\\s+").toList.map(_.toInt))
    }.getOrElse(List(List()))


    buildTriangle(0, nodes) match {
      case Some(triangle) =>
        val minPath = findMinPath(triangle)
        println(s"Minimal path is: ${minPath.mkString(" + ")} = ${minPath.sum}")
      case None =>
        println("Triangle cannot be constructed")
    }
  }
}