package org.pfcoperez.scalawk.entities

trait Statement extends AwkElement

//It might have side effects but returns a value
trait StatementWithResult extends Statement

trait SideEffectStatement extends Statement

case class Assignment(left: Identifier, value: StatementWithResult) extends SideEffectStatement {
  override def toAwk: String = s"${left.toAwk} = ${value.toAwk}"
}
