package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.{AwkExpression, SideEffectStatement}
import org.pfcoperez.scalawk.transitions.{ToCommandWithLineProgram, ToSolidCommand}

class CommandWithInitialProgram(program: Seq[SideEffectStatement])(prev: AwkCommand) extends AwkCommand(prev)
  with ToSolidCommand
  with ToCommandWithLineProgram {

  override private[scalawk] val initialProgram: Seq[SideEffectStatement] = program

}
