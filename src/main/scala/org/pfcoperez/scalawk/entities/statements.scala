package org.pfcoperez.scalawk.entities

trait Statetement extends AwkElement

//It might have side effects but returns a value
trait StatementWithResult extends Statetement

trait SideEffectStatement extends Statetement

case class Assignment(left: Identifier, value: StatementWithResult) extends SideEffectStatement {
  override def toAwk: String = s"${left.toAwk} = ${value.toAwk}"
}
