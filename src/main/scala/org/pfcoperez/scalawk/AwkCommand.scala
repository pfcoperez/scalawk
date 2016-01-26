package org.pfcoperez.scalawk

import org.pfcoperez.scalawk.entities.{SideEffectStatement, AwkExpression}

abstract class AwkCommand protected(
  private[scalawk] val commandOptions: Seq[String] = Seq.empty,
  private[scalawk] val linePresentation: Seq[AwkExpression] = Seq.empty,
  private[scalawk] val lineProgram: Seq[SideEffectStatement] = Seq.empty,
  private[scalawk] val initialProgram: Seq[SideEffectStatement] = Seq.empty,
  private[scalawk] val endProgram: Seq[SideEffectStatement] = Seq.empty
) {
  def this(prev: AwkCommand) = this(
    prev.commandOptions,
    prev.linePresentation,
    prev.lineProgram,
    prev.initialProgram,
    prev.endProgram
  )
}
