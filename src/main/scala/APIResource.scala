sealed trait APIResource[R]

object APIResource {

  import api._

  implicit val projectsResource = new APIResource[Projects] {}
  implicit val tasksResource = new APIResource[Tasks] {}
  implicit val labelsResource = new APIResource[Labels] {}
  implicit val commentsResource = new APIResource[Comments] {}
}
