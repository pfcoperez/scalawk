package org.pfcoperez.scalawk

import org.scalatest.{Matchers, WordSpec}

class DslIT extends WordSpec with Matchers {

  "An AWK DSL"  should {

    "Create a basic AWK command " in {
      val builder = lines splittedBy "_+".r arePresentedAs ('c1, " ", 'c2, "hello", 1, 'x)
      builder.toAwk shouldBe """awk -F '_+' '{print $1" "$2"hello"1x}'"""
    }

  }


}
