package org.pfcoperez.scalawk.entities

trait Literal extends AwkExpression

case class StringLiteral(v: String) extends Literal {
  override def toAwk: String = s""""$v""""
}

case class NumericLiteral(v: Any) extends Literal {
  override def toAwk: String = v.toString
}

case class Identifier(name: String) extends AwkExpression {
  override def toAwk: String = name

  def :=(value: StatementWithResult): Assignment = Assignment(this, value)

}