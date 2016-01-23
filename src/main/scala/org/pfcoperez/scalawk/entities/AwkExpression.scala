package org.pfcoperez.scalawk.entities

trait AwkExpression extends StatementWithResult {

  def +(that: AwkExpression): StatementWithResult = Add(this, that)
  def -(that: AwkExpression): StatementWithResult = Sub(this, that)
  def /(that: AwkExpression): StatementWithResult = Divide(this, that)
  def *(that: AwkExpression): StatementWithResult = Multiply(this, that)

}
