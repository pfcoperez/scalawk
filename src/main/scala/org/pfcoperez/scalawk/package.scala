package org.pfcoperez

import org.pfcoperez.scalawk.entities._

trait AwkConversions {

  // Scala types to literal expressions

  implicit def string2lit(x: String): StringLiteral = StringLiteral(x)
  implicit def int2lit(x: Int): NumericLiteral = NumericLiteral(x)
  implicit def double2lit(x: Double): NumericLiteral = NumericLiteral(x)

  // Symbols to identifiers

  implicit def symbol2id(x: Symbol): Identifier = {
    val cexp = """c(\d+)""".r
    x.name match {
      case cexp(d) => Identifier("$" + d)
      case other => Identifier(other)
    }
  }

  // Awk element to its string representation

  implicit def solidAwkCommand2string(x: AwkElement): String = x.toAwk

}

trait Util {
  object present {
    def apply(varExpressions: AwkExpression*): Print =
      Print(varExpressions)
  }
}

package object scalawk extends AwkConversions with Util
