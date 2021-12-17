package $package$

import munit.FunSuite

class TestMain extends FunSuite {
  test("test.env") {
    assertEquals(sys.env.getOrElse("APPLICATION_NAME", "???"), "$name$")
  }
}
