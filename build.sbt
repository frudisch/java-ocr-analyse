name := "java-ocr-analyse"

scalaVersion := "2.11.7"

version           := "0.1.0-SNAPSHOT"

organization      := "com.practicum.web.architecture.ocr"

publishMavenStyle := true

crossPaths       := false

autoScalaLibrary := false

libraryDependencies ++= Seq(
  "org.languagetool" % "language-en" % "3.1",
  "org.apache.lucene" % "lucene-core" % "5.3.1",
  "org.apache.lucene" % "lucene-spellchecker" % "3.6.2"
)
