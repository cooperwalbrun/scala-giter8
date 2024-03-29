lazy val root = project
  .in(file("."))
  $if(build_info.truthy)$
  .enablePlugins(BuildInfoPlugin)
  $endif$
  .settings(
    name := "$name;format="lower,hyphen"$",
    version := "0.1.0",
    scalaVersion := "3.2.1",
    trapExit := false, // See: https://stackoverflow.com/a/41390137
    $if(build_info.truthy)$
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "$package$",
    $endif$
    $if(create_standalone_jar.truthy)$
    assembly / artifact := (assembly / artifact).value.withClassifier(Some("assembly")),
    addArtifact(assembly / artifact, assembly), // Tells SBT to create an additional artifact that inlines all classpath dependencies (a.k.a. an "uber JAR")
    $endif$
    libraryDependencies ++= Seq(
      $if(cats.truthy)$
      // Cats (functional programming)
      "org.typelevel" %% "cats-core" % "2.8.0",
      "org.typelevel" %% "cats-effect" % "3.3.14",

      // TODO - add your dependencies here...

      // Testing
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
      $else$
      // TODO - add your dependencies here...

      // Testing
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      $endif$
    ),
    run / fork := true,$if(cats.truthy)$ // This prevents the "non-daemon" log messages that Cats Effect writes, allowing us to not have to specify the JVM argument cats.effect.logNonDaemonThreadsOnExit$endif$
    Test / fork := true$if(dotenv.truthy)$, // This is necessary in order for dotenv to actually configure environment variables for unit tests
    ThisBuild / envFileName := "desktop.env", // This file is not used in "real" environments as we do not run the code using SBT (instead, we run the JAR directly with something like the "java" command)
    Test / envFileName := "test.env",
    Test / envVars := (Test / envFromFile).value
    $endif$
  )
