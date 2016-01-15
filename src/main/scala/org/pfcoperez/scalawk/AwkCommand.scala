package org.pfcoperez.scalawk

import org.pfcoperez.scalawk.entities.{SideEffectStatement, AwkExpression}

trait AwkCommand {
  private[scalawk] val commandOptions: Seq[String] = Seq.empty
  private[scalawk] val linePresentation: Seq[AwkExpression] = Seq.empty
  private[scalawk] val lineProgram: Seq[SideEffectStatement] = Seq.empty
}
