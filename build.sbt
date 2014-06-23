import AssemblyKeys._
import de.johoop.jacoco4sbt._
import JacocoPlugin._
import sbtassembly.Plugin._

jarName in assembly := name.value + ".jar"

name := "sparkdemo"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "postgresql" % "postgresql" % "8.4-701.jdbc4",
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "tw.edu.ntu.csie" % "libsvm" % "3.17",
  "nz.ac.waikato.cms.weka" % "weka-dev" % "3.7.6",
  "org.apache.commons" % "commons-math3" % "3.3",
  "com.github.seratch" %% "awscala" % "0.2.+",
  "org.apache.spark" % "spark-core_2.10" % "1.0.0"
)

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

assemblySettings

net.virtualvoid.sbt.graph.Plugin.graphSettings

test in assembly := {}

jacoco.settings

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("META-INF","mailcap", xs @ _*)         => MergeStrategy.first
  case PathList("META-INF","ECLIPSEF.RSA", xs @ _*)         => MergeStrategy.first
  case x => old(x)
}
}