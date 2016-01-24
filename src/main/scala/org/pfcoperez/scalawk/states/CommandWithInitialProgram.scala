package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.{AwkExpression, SideEffectStatement}
import org.pfcoperez.scalawk.transitions.{ToCommandWithLineProgram, ToSolidCommand}

class CommandWithInitialProgram(initialProgram: Seq[SideEffectStatement])(prev: AwkCommand) extends AwkCommand
  with ToSolidCommand
  with ToCommandWithLineProgram {

  override private[scalawk] val commandOptions: Seq[String] = prev.commandOptions
  override private[scalawk] val linePresentation: Seq[AwkExpression] = prev.linePresentation
  override private[scalawk] val lineProgram: Seq[SideEffectStatement] = prev.lineProgram

  override private[scalawk] val initialProgram: Seq[SideEffectStatement] = prev.initialProgram

  override private[scalawk] val endProgram: Seq[SideEffectStatement] = _
  override private[scalawk] val fs: Option[String] = _

}
