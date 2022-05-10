ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "testing-io"
  )

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "3.3.11",
  "org.scalatest" %% "scalatest" % "3.2.12" % Test,
  "org.scalamock" %% "scalamock" % "5.2.0" % Test,
  "org.typelevel" %% "cats-effect-testing-scalatest" % "1.4.0" % Test
)

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")