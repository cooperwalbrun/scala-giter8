package $package$

$if(cats.truthy)$
import cats.effect.std.Console
import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  $if(build_info.truthy)$
  // The name/version below come from build.sbt, and is made available to our Scala code at runtime
  // (in the $package$ package) thanks to https://github.com/sbt/sbt-buildinfo
  val ApplicationName = BuildInfo.name
  val ApplicationVersion = BuildInfo.version
  $endif$
  $if(dotenv.truthy)$val EnvironmentVariable = sys.env.getOrElse("SOME_ENV_VAR", "???") // Comes from the .env file$endif$

  final override def run(args: List[String]): IO[ExitCode] = Console[IO]
    $if(build_info.truthy)$
    .println(s"Hello from v\$ApplicationVersion of \$ApplicationName$if(dotenv.truthy)$ (\$EnvironmentVariable)$endif$!")
    $else$
    $if(dotenv.truthy)$
    .println(s"Hello from \$EnvironmentVariable!")
    $else$
    .println("Hello from Scala 3!")
    $endif$
    $endif$
    .as(ExitCode.Success)
}
$else$
$if(build_info.truthy)$
// The name/version below come from build.sbt, and is made available to our Scala code at runtime
// (in the $package$ package) thanks to https://github.com/sbt/sbt-buildinfo
val ApplicationName = BuildInfo.name
val ApplicationVersion = BuildInfo.version
$endif$
$if(dotenv.truthy)$val EnvironmentVariable = sys.env.getOrElse("SOME_ENV_VAR", "???") // Comes from the .env file$endif$

@main
$if(build_info.truthy)$
def hello: Unit =
  println(s"Hello from v\$ApplicationVersion of \$ApplicationName$if(dotenv.truthy)$ (\$EnvironmentVariable)$endif$!")
$else$
$if(dotenv.truthy)$
def hello: Unit = println(s"Hello from \$EnvironmentVariable!")
$else$
def hello: Unit = println("Hello from Scala 3!")
$endif$
$endif$
$endif$
