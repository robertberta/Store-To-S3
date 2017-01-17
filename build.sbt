name := "ddk"

version := "1.0"

lazy val `ddk` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test )

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"

libraryDependencies += "com.typesafe.play" % "anorm_2.11" % "3.0.0-M1"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  