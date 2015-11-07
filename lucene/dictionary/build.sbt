name := "lucene-analyzers"

version := "0.0.1-SNAPSHOT"

organization := "littlewings"

libraryDependencies ++= Seq(
  "org.apache.lucene" % "lucene-core" % "4.10.3",
  "org.apache.lucene" % "lucene-analyzers-common" % "4.10.3",
  "org.apache.lucene" % "lucene-analyzers-kuromoji" % "4.10.3"
)
