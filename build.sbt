import Dependencies._



lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := scalaVersionNo,
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  javaOptions ++= Seq("-Xmx4G", "-XX:+UseConcMarkSweepGC"),
  resolvers ++=myRepositories
)

lazy val romanNumerals = (project in file(".")). 
                settings(commonSettings: _*).
                settings(
                   libraryDependencies ++= equalExpertsDependencies
                )
               
				  