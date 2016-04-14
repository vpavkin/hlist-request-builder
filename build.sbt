lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-unchecked",
  "-Xfatal-warnings",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture"
)

lazy val shapelessVersion = "2.3.0"

lazy val hlistRequestBuilder = project.in(file("."))
  .settings(
    organization := "ru.pavkin",
    name := "hlist-request-builder",
    scalaVersion := "2.11.8",
    description := "Typesafe request builder example",
    scalacOptions ++= compilerOptions,
    libraryDependencies ++= Seq(
      "com.chuusai" %% "shapeless" % shapelessVersion
    )
  )

