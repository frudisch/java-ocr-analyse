name := "java-ocr-analyse"

scalaVersion := "2.11.7"

version           := "0.1.0-SNAPSHOT"

organization      := "com.practicum.web.architecture.ocr"

publishMavenStyle := true

crossPaths       := false

autoScalaLibrary := false

libraryDependencies += "net.sourceforge.tess4j" % "tess4j" % "1.3.0"