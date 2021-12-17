package $package$

$if(cats.truthy)$
import cats.effect.IO
import munit.CatsEffectSuite

class TestMain extends CatsEffectSuite {
  $if(dotenv.truthy)$
  test("test.env") {
    assertIO(IO(sys.env.getOrElse("SOME_ENV_VAR", "???")), "unit-test")
  }
  $else$
  test("true == true") {
    assertIO(IO.pure(true), true)
  }
  $endif$
}
$else$
import munit.FunSuite

class TestMain extends FunSuite {
  $if(dotenv.truthy)$
  test("test.env") {
    assertEquals(sys.env.getOrElse("SOME_ENV_VAR", "???"), "unit-test")
  }
  $else$
  test("true == true") {
    assertEquals(true, true)
  }
  $endif$
}
$endif$
