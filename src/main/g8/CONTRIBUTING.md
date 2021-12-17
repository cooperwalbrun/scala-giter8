# Contributing to $name;format="lower,hyphen"$

1. [Commands](#commands)
2. [Scalafmt](#scalafmt)
3. [Changelog](#changelog)

## Commands

* `sbt compile` - compile the code
* `sbt run` - run the code
* `sbt test` - run unit tests
* `sbt coverage test` - run unit tests with code coverage - *this is not supported in Scala 3 yet, which results in SBT being unable to
resolve all dependencies of the plugin - therefore, the plugin is temporarily commented out in
[project/plugins.sbt](project/plugins.sbt)*
  * Follow
  [scoverage/scalac-scoverage-plugin#299](https://github.com/scoverage/scalac-scoverage-plugin/issues/299)
  and [lampepfl/dotty#13880](https://github.com/lampepfl/dotty/pull/13880) to keep up-to-date with the
  status of this functionality gap

## Scalafmt

This project uses [Scalafmt](https://scalameta.org/scalafmt/) to handle formatting, and
contributions to its code are expected to be formatted with it (within reason) using the settings in
[.scalafmt.conf](.scalafmt.conf).

## Changelog

This project uses a [CHANGELOG.md](CHANGELOG.md) to track changes. Please update this document along
with your changes when you make a pull request (you can place your changes beneath the `Unreleased`
section near the top). Please also tag your line items with a reference to your GitHub profile. You
should use the formatting that is already in place (see the document for more information).
