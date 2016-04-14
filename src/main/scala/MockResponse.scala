import model._
import api._
import shapeless.{HList, ::, HNil}

sealed trait MockResponse[R] {
  def value: R
}

object MockResponse {

  def apply[R](v: R): MockResponse[R] = new MockResponse[R] {
    def value: R = v
  }

  implicit val projectsResponse = MockResponse[Projects](List(
    Project("project1"),
    Project("project2")
  ))
  implicit val tasksResponse = MockResponse[Tasks](List(
    Task("task1", true),
    Task("task2", false)
  ))
  implicit val labelsResponse = MockResponse[Labels](List(
    Label("label", "black")
  ))
  implicit val commentsResponse = MockResponse[Comments](Nil)

  implicit val hnilResponse = MockResponse[HNil](HNil)

  implicit def hlistResponse[R, L <: HList](implicit R: MockResponse[R],
                                            L: MockResponse[L]): MockResponse[R :: L] =
    new MockResponse[R :: L] {
      def value: R :: L = R.value :: L.value
    }
}



