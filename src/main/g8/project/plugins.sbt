addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.20")
$if(build_info.truthy)$
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.10.0")
$endif$
$if(dotenv.truthy)$
addSbtPlugin("au.com.onegeek" % "sbt-dotenv" % "2.1.233")
$endif$
// addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.9.0")
