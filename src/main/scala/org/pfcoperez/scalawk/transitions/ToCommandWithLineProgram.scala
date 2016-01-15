package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.entities.SideEffectStatement
import org.pfcoperez.scalawk.states.{CommandWithSeparator, CommandWithLineProgram}

//object ToCommandWithLineProgram

trait ToCommandWithLineProgram {
  self: CommandWithSeparator =>

  def considering(lines: SideEffectStatement*): CommandWithLineProgram =
    new CommandWithLineProgram(lines)(self)

}
