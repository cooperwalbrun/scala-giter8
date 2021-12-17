package $package$

$if(cats.truthy)$
import cats.effect.IO
import munit.CatsEffectSuite

class TestMain extends CatsEffectSuite {
  test("test.env") {
    assertIO(IO(sys.env.getOrElse("APPLICATION_NAME", "???")), "$name$")
  }
}
$else$
import munit.FunSuite

class TestMain extends FunSuite {
  test("test.env") {
    assertEquals(sys.env.getOrElse("APPLICATION_NAME", "???"), "$name$")
  }
}
$endif$
