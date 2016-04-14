package model

case class Project(name: String)
case class Task(content: String, isCompleted: Boolean)
case class Label(name: String, color: String)
case class Comment(taskId: String, text: String)
