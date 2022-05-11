addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.3.1")
$if(build_info.truthy)$
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")
$endif$
$if(dotenv.truthy)$
addSbtPlugin("nl.gn0s1s" % "sbt-dotenv" % "3.0.0")
$endif$
$if(create_standalone_jar.truthy)$
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.2.0")
$endif$
// addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.9.3")
