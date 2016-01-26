package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.SideEffectStatement
import org.pfcoperez.scalawk.states.CommandWithLineProgram

//object ToCommandWithLineProgram

trait ToCommandWithLineProgram {
  self: AwkCommand =>

  def computing(lines: SideEffectStatement*): CommandWithLineProgram =
    new CommandWithLineProgram(lines)(self)

}
