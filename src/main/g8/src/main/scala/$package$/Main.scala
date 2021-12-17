package $package$

$if(cats.truthy)$
import cats.effect.std.Console
import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  // The version below comes from build.sbt, and is made available to our Scala code at runtime (in
  // the $package$ package) thanks to https://github.com/sbt/sbt-buildinfo
  val ThisApplicationVersion = BuildInfo.version
  val ApplicationName = sys.env.getOrElse("APPLICATION_NAME", "???") // Comes from the .env file

  final override def run(args: List[String]): IO[ExitCode] = Console[IO]
    .println(s"Hello from v\$ThisApplicationVersion of \$ApplicationName")
    .as(ExitCode.Success)
}
$else$
val ThisApplicationVersion = BuildInfo.version
val ApplicationName = sys.env.getOrElse("APPLICATION_NAME", "???") // Comes from the .env file

@main
def hello: Unit = println(s"Hello from v\$ThisApplicationVersion of \$ApplicationName")
$endif$
