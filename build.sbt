ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "root"
  )

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _                            => throw new Exception("Unknown platform!")
}

// Add JavaFX dependencies
lazy val javaFXModules =
  Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")

libraryDependencies ++= javaFXModules.map(m =>
  "org.openjfx" % s"javafx-$m" % "17.0.14" classifier osName
)
