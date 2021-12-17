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
