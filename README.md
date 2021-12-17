# scala-giter8 ![master](https://github.com/cooperwalbrun/scala-giter8/workflows/master/badge.svg)

## Overview

This is a straightforward Scala 3 [Giter8](http://www.foundweekends.org/giter8/index.html) template.
It provides a reasonable [.scalafmt.conf](https://scalameta.org/scalafmt/docs/configuration.html)
and allows users to optionally scaffold some minimal [Cats](http://typelevel.org/cats/)
configuration.

## Usage

### With Cats

```bash
g8 cooperwalbrun/scala-giter8 \
  --name='My Application Name' \
  --package='com.mycompany.package' \
  --cats=yes
```

### Without Cats

```bash
g8 cooperwalbrun/scala-giter8 \
  --name='My Application Name' \
  --package='com.mycompany.package' \
  --cats=no
```

## Test Locally

When contributing to this template, it is useful to be able to run it from your local machine to
generate test applications. This can be done like so:

```bash
g8 file:///some/path/scala-giter8 ...
```

In the example above, the path that this repository's source code is in is
`/some/path/scala-giter8`. Note how we prefix it with `file://`, leading to three consecutive
slashes.
