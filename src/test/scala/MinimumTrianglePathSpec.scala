import org.scalatest.wordspec.AnyWordSpec

class MinimumTrianglePathSpec extends AnyWordSpec {

  val nodes = List(
    List(7),
    List(6, 3),
    List(3, 8, 5),
    List(11, 2, 10, 9)
  )

  val triangle = Triangle(7,
    Some(Triangle(6,
      Some(Triangle(3,
        Some(Triangle(11, None, None)),
        Some(Triangle(2, None, None)))),
      Some(Triangle(8, Some(Triangle(2, None, None)),
        Some(Triangle(10, None, None)))))),
    Some(Triangle(3,
      Some(Triangle(8,
        Some(Triangle(2, None, None)),
        Some(Triangle(10, None, None)))),
      Some(Triangle(5,
        Some(Triangle(10, None, None)),
        Some(Triangle(9, None, None)))))))

  "buildTriangle" should {
    "construct triangle if input is correct" in {
      val result = MinimumTrianglePath.buildTriangle(0, nodes)

      assert(result.isDefined)
      assert(result.contains(triangle))
    }

    "fails if input is empty" in {
      val triangle = MinimumTrianglePath.buildTriangle(0, List())
      assert(triangle.isEmpty)
    }
  }

  "findMinPath" should {
    "correctly find minimum path" in {
      val result = MinimumTrianglePath.findMinPath(triangle)

      assert(result.size == 4)
      assert(result == List(7, 6, 3, 2))
      assert(result.sum == 18)
    }

    "return 0 from empty triangle" in {
      val result = MinimumTrianglePath.findMinPath(Triangle(0, None, None))

      assert(result.size == 1)
      assert(result.sum == 0)
    }
  }

}
