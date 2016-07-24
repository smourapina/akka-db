name := "com/akka-db"

version := "1.0"

scalaVersion := "2.11.7"

val akkaVersion = "2.3.11"
val specs2Version = "3.8.4"
val scalaCheckVersion = "1.13.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "org.specs2" %% "specs2-core" % specs2Version % "test",
  "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

