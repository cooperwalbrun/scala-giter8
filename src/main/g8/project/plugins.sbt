addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.4.1")
$if(build_info.truthy)$
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")
$endif$
$if(dotenv.truthy)$
addSbtPlugin("nl.gn0s1s" % "sbt-dotenv" % "3.0.0")
$endif$
$if(create_standalone_jar.truthy)$
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.2.0")
$endif$
// Note: scoverage 2.0.0 and above works with Scala 3.2.0-RC1 and later
// Refer to this issue to track scoverage and Scala 3 compatibility: https://github.com/scoverage/scalac-scoverage-plugin/issues/299
// addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.1")
