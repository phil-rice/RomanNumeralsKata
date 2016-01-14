import sbt._
object Dependencies {
  // Versions
  val scalaVersionNo = "2.11.7"
  val scalaPlusPlayTestVersion = "1.4.0-M3"
  val scalaStmVersion = "0.7"

  // Libraries
//  val scalaStm = "org.scala-stm" %% "scala-stm" % scalaStmVersion
  val scalaPlusPlay = "org.scalatestplus" %% "play" % scalaPlusPlayTestVersion % Test
  //Repositories
  val myRepositories = Seq("scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")

  // Projects Dependencies
  val equalExpertsDependencies = Seq( scalaPlusPlay)
}