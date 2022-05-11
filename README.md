# scala-giter8 ![master](https://github.com/cooperwalbrun/scala-giter8/workflows/master/badge.svg)

1. [Overview](#overview)
2. [Usage](#usage)
   1. [Default (All Features Enabled)](#default-all-features-enabled)
   2. [Opt Out of Cats](#opt-out-of-cats)
   3. [Opt Out of the BuildInfo Plugin](#opt-out-of-the-buildinfo-plugin)
   4. [Opt Out of .env File Support](#opt-out-of-env-file-support)
   5. [Opt Out of Creating a Standalone JAR](#opt-out-of-creating-a-standalone-jar)
3. [Testing Locally](#testing-locally)

## Overview

This is a straightforward Scala 3 [Giter8](http://www.foundweekends.org/giter8/index.html) template.
It provides a reasonable [.scalafmt.conf](https://scalameta.org/scalafmt/docs/configuration.html)
alongside some common production/enterprise-friendly application features.

## Usage

### Default (All Features Enabled)

Provisions an application which uses all the following:

* [Cats](http://typelevel.org/cats/)
* [sbt-buildinfo](https://github.com/sbt/sbt-buildinfo)
* [sbt-dotenv](https://github.com/Philippus/sbt-dotenv)
* [sbt-assembly](https://github.com/sbt/sbt-assembly)

```bash
g8 cooperwalbrun/scala-giter8 \
  --name='My Application Name' \
  --package='com.mycompany.package'
```

### Opt Out of Cats

```bash
g8 cooperwalbrun/scala-giter8 \
  ... \
  --cats=no
```

### Opt Out of the BuildInfo Plugin

If you do not need access to any of the following at runtime in your application:

* `name` in `build.sbt`
* `version` in `build.sbt`
* `sbt.version` in `project/build.properties`

then you can opt out of using the `sbt-buildinfo` plugin as shown below.

```bash
g8 cooperwalbrun/scala-giter8 \
  ... \
  --build_info=no
```

### Opt Out of .env File Support

```bash
g8 cooperwalbrun/scala-giter8 \
  ... \
  --dotenv=no
```

### Opt Out of Creating a Standalone JAR

If you do not need to produce a JAR that can be executed on its own with, for example, the
`java -jar` command, you can opt out of using the `sbt-assembly` plugin as shown below.

>Note that this is not recommended if your Scala project is going to be an *application*. However,
>it *is* recommended to opt out of this option if your Scala project is going to be a *library or
>framework*.

```bash
g8 cooperwalbrun/scala-giter8 \
  ... \
  --create_standalone_jar=no
```

## Testing Locally

When contributing to this template, it is useful to be able to run it from your local machine to
generate test applications. This can be done like so:

```bash
g8 file:///some/path/scala-giter8 ...
```

In the example above, the path that this repository's source code resides in is
`/some/path/scala-giter8`. Note how we prefix it with `file://`, leading to three consecutive
slashes.
