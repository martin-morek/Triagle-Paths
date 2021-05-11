name := "triaglePaths"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.2.5",
  "org.scalatest" %% "scalatest" % "3.2.5" % "test"
)

lazy val minimumTrianglePath = (project in file(".")).
  settings(
    assembly / assemblyJarName := "MinTrianglePath.jar"
  )