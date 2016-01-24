package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.SideEffectStatement
import org.pfcoperez.scalawk.states.CommandWithInitialProgram

trait ToCommandWithInitialProgram {
  self: AwkCommand =>

  def provided(initialProgram: SideEffectStatement*): CommandWithInitialProgram = new CommandWithInitialProgram

}
