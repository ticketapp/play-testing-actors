name := """play actors test"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"
lazy val akkaVersion = "2.4.4"

libraryDependencies ++= Seq(
  specs2 % Test,
  "net.codingwell" %% "scala-guice" % "4.0.0",
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test",
  "com.lihaoyi" %% "sourcecode" % "0.1.0",
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-distributed-data-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-contrib" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
