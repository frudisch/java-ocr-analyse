name := "java-ocr-analyse"

scalaVersion := "2.11.7"

version           := "1.0.0"

organization      := "com.practicum.web.architecture.ocr"

publishMavenStyle := true

crossPaths       := false

autoScalaLibrary := false

unmanagedJars in Compile := (baseDirectory.value ** "*.jar").classpath

libraryDependencies ++= Seq(
  "org.languagetool" % "language-en" % "3.1",
  "net.sourceforge.tess4j" % "tess4j" % "2.0.1",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)
