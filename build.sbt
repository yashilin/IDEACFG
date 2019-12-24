resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

name := "json_reader_shilin"

version := "0.0.1"

scalaVersion := "2.11.12"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"  % "provided"
libraryDependencies += "com.databricks" % "spark-xml_2.11" % "0.4.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.2.0"


libraryDependencies += "mrpowers" % "spark-daria" % "0.35.2-s_2.11"

libraryDependencies += "MrPowers" % "spark-fast-tests" % "0.20.0-s_2.11" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.7"



// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

// JAR file settings

// don't include Scala in the JAR file
//assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

// Add the JAR file naming conventions described here: https://github.com/MrPowers/spark-style-guide#jar-files
// You can add the JAR file naming conventions by running the shell script
