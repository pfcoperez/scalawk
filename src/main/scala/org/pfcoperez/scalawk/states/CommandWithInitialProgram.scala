package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.SideEffectStatement
import org.pfcoperez.scalawk.transitions.{ToCommandWithLineProgram, ToSolidCommand}

class CommandWithInitialProgram(initialProgram: Seq[SideEffectStatement]) extends AwkCommand
  with ToSolidCommand
  with ToCommandWithLineProgram {

}
