organization := "org"

version := "1.0-SNAPSHOT"

name := "spatial-app"

scalaVersion := "2.12.7"
val paradiseVersion = "2.1.0"

// libraryDependencies ++= Seq("edu.stanford.cs.dawn" %% "spatial" % "1.0")
libraryDependencies ++= Seq("edu.stanford.cs.dawn" %% "spatial" % "1.1-SNAPSHOT")

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository/"
resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += Resolver.sonatypeRepo("releases")

addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full)

