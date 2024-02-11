ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "core",
    idePackagePrefix := Some("ru.intfox.jsonrpc4cats"),
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % "0.14.6",
      "org.typelevel" %% "cats-effect-kernel" % "3.5.3"
    )
  )
