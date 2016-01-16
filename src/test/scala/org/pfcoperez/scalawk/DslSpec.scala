package org.pfcoperez.scalawk

import org.pfcoperez.scalawk.states.CommandWithLineProgram
import org.scalatest.{Matchers, WordSpec}

class DslSpec extends WordSpec with Matchers {

  "An AWK DSL"  should {

    "Create a basic AWK command " in {
      val builder = lines splittedBy "_+".r arePresentedAs ('c1, " ", 'c2, "hello", 1, 'x)
      builder.toAwk shouldBe """awk -F '_+' '{print $1 " " $2 "hello" 1 x}'"""
    }

    "Create an AWK command with intermeidate variables" in {
      val builder = lines considering ('x := 3, 'y := 2) arePresentedAs('c1, " ", 'x, 'y)
      builder.toAwk shouldBe """awk '{x = 3; y = 2; print $1 " " x y}'"""

    }
  }


}
