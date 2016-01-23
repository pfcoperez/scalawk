package org.pfcoperez.scalawk.entities

trait Statement extends AwkElement

//It might have side effects but returns a value
trait StatementWithResult extends Statement

trait SideEffectStatement extends Statement

// Side effects

case class Assignment(left: Identifier, value: StatementWithResult) extends SideEffectStatement {
  override def toAwk: String = s"${left.toAwk} = ${value.toAwk}"
}

case class Print(expressions: Seq[AwkExpression]) extends SideEffectStatement {
  override def toAwk: String = "print " + { expressions.map(_.toAwk) mkString " " }
}

// With result statements

trait ArithmeticOperator extends StatementWithResult {

  protected val operator: String

  val left: StatementWithResult
  val right: StatementWithResult

  override def toAwk: String = s"${left.toAwk} $operator ${right.toAwk}"
}

case class Add(left: StatementWithResult, right: StatementWithResult) extends ArithmeticOperator {
  override protected val operator: String = "+"
}

case class Sub(left: StatementWithResult, right: StatementWithResult) extends ArithmeticOperator {
  override protected val operator: String = "-"
}

case class Divide(left: StatementWithResult, right: StatementWithResult) extends ArithmeticOperator {
  override protected val operator: String = "/"
}

case class Multiply(left: StatementWithResult, right: StatementWithResult) extends ArithmeticOperator {
  override protected val operator: String = "*"
}

case class Parenthesis(subStatement: StatementWithResult) extends StatementWithResult {
  override def toAwk: String = s"(${subStatement.toAwk})"
}