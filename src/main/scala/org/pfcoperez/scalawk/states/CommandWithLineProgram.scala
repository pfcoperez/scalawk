package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.SideEffectStatement
import org.pfcoperez.scalawk.transitions.ToSolidCommand

class CommandWithLineProgram(
                              statements: Seq[SideEffectStatement]
                            )(prev: AwkCommand) extends AwkCommand(prev)
  with ToSolidCommand {

  override private[scalawk]val lineProgram: Seq[SideEffectStatement] = statements
  
}
