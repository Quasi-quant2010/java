name := "kuromoji"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.9.1"

organization := "littlewings"

resolvers += "Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika"

//"org.apache.solr" % "solr-core" % "3.5.0",
//"org.apache.solr" % "solr-solrj" % "3.5.0"

libraryDependencies ++= Seq(
  "org.atilika.kuromoji" % "kuromoji" % "0.7.7"
)
