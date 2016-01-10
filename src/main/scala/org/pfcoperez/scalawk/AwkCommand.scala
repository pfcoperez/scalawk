package org.pfcoperez.scalawk

import org.pfcoperez.scalawk.entities.{AwkExpression, AwkElement}

trait AwkCommand {
  val commandOptions: Seq[String] = Seq.empty
  def linePresentation: Seq[AwkExpression] = Seq.empty
}
