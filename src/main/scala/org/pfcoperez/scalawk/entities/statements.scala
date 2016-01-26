package org.pfcoperez.scalawk.entities

trait Statement extends AwkElement

//It might have side effects but returns a value
trait StatementWithResult extends Statement

trait SideEffectStatement extends Statement

// Side effects

case class Assignment(left: Identifier, value: StatementWithResult) extends SideEffectStatement {
  override def toAwk: String = s"${left.toAwk} = ${value.toAwk}"
}

case class Print(exps: Seq[AwkExpression]) extends SideEffectStatement {
  override def toAwk: String = "print " + { exps.map(_.toAwk) mkString " " }
}

// With result statements

trait OperatorStatement extends StatementWithResult {

  protected val operator: String
  protected val leftContext: String => String = x => x
  protected val rightContext: String => String = x => x

  val left: StatementWithResult
  val right: StatementWithResult

  override def toAwk: String = s"${leftContext(left.toAwk)} $operator ${rightContext(right.toAwk)}"
}

case class Add(left: StatementWithResult, right: StatementWithResult) extends OperatorStatement {
  override protected val operator: String = "+"
}

case class Sub(left: StatementWithResult, right: StatementWithResult) extends OperatorStatement {
  override protected val operator: String = "-"
}

trait PriorityOperators extends OperatorStatement {
  override val rightContext: (String) => String = x => right match {
    case Add(_,_) | Sub(_,_) => s"($x)"
    case _ => x
  }
  override val leftContext: (String) => String = x => left match {
    case Add(_,_) | Sub(_,_) => s"($x)"
    case _ => x
  }
}

case class Divide(left: StatementWithResult, right: StatementWithResult) extends PriorityOperators {
  override protected val operator: String = "/"
}

case class Multiply(left: StatementWithResult, right: StatementWithResult) extends PriorityOperators {
  override protected val operator: String = "*"
}

case class Concat(left: StatementWithResult, right: StatementWithResult) extends OperatorStatement {
  override protected val operator: String = ""
}