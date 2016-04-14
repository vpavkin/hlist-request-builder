import model._

object api {

  type Projects = List[Project]
  type Tasks = List[Task]
  type Labels = List[Label]
  type Comments = List[Comment]

  val builder = new Builder
}
