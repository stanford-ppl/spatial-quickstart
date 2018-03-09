organization := "org"

version := "1.0-SNAPSHOT"

name := "spatial-app"

scalaVersion := "2.12.1"
val paradiseVersion = "2.1.0"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-language:reflectiveCalls")

libraryDependencies ++= Seq("edu.stanford.cs.dawn" %% "spatial" % "0.1-SNAPSHOT")

scalaSource in Compile := baseDirectory.value / "src"

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
  // "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository/",
)
addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full)


