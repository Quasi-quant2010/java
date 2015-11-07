name := "lucene-analyzers"

version := "0.0.1-SNAPSHOT"

organization := "littlewings"

//resolvers += "Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika"

libraryDependencies ++= Seq(
  "org.apache.lucene" % "lucene-core" % "4.10.3",
  "org.apache.lucene" % "lucene-analyzers-common" % "4.10.3",
  "org.apache.lucene" % "lucene-analyzers-kuromoji" % "4.10.3"
)
