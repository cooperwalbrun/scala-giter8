lazy val root = project
  .in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name             := "$name;format="lower,hyphen"$",
    version          := "0.1.0",
    scalaVersion     := "$scala3_version$",
    trapExit         := false, // See: https://stackoverflow.com/a/41390137
    buildInfoKeys    := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "$package$",
    libraryDependencies ++= Seq(
      $if(cats.truthy)$
      // Cats (functional programming)
      "org.typelevel" %% "cats-core"   % "$cats_core_version$",
      "org.typelevel" %% "cats-effect" % "$cats_effect_version$",

      // Testing
      "org.scalameta" %% "munit"               % "$munit_version$" % Test,
      "org.typelevel" %% "munit-cats-effect-3" % "$munit_cats_version$" % Test
      $else$
      // TODO - add your dependencies here...

      // Testing
      "org.scalameta" %% "munit" % "$munit_version$" % Test,
      $endif$
    ),
    run / fork              := true, // This prevents the "non-daemon" log messages that Cats Effect writes, allowing us to not have to specify the JVM argument cats.effect.logNonDaemonThreadsOnExit
    ThisBuild / envFileName := "desktop.env", // This file is not used in remote environments as we don't run the code using SBT
    Test / fork             := true, // This is necessary in order for dotenv to actually configure environment variables for unit tests
    Test / envFileName      := "test.env",
    Test / envVars          := (Test / envFromFile).value
  )
