package org.pfcoperez.scalawk

import org.pfcoperez.scalawk.entities.{SideEffectStatement, AwkExpression}

trait AwkCommand {
  protected val commandOptions: Seq[String] = Seq.empty
  protected val linePresentation: Seq[AwkExpression] = Seq.empty
  protected val lineProgram: Seq[SideEffectStatement] = Seq.empty
}
