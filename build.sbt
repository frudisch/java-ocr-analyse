name := "java-ocr-analyse"

scalaVersion := "2.11.7"

version           := "0.1.0-SNAPSHOT"

organization      := "com.practicum.web.architecture.ocr"

publishMavenStyle := true

crossPaths       := false

autoScalaLibrary := false

libraryDependencies ++= Seq(
  "org.languagetool" % "language-en" % "3.1",
  "net.sourceforge.tess4j" % "tess4j" % "2.0.1",
  "gov.nih.imagej" % "imagej" % "1.47"
)
