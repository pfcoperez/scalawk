package org.pfcoperez.scalawk.entities

trait AwkExpression extends StatementWithResult {

  def +(that: StatementWithResult): StatementWithResult = Add(this, that)
  def -(that: StatementWithResult): StatementWithResult = Sub(this, that)
  def /(that: StatementWithResult): StatementWithResult = Divide(this, that)
  def *(that: StatementWithResult): StatementWithResult = Multiply(this, that)
  def ++(that: StatementWithResult): StatementWithResult = Concat(this, that)

}
