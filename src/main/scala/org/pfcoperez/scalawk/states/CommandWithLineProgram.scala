package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.SideEffectStatement

class CommandWithLineProgram(
                              statements: Seq[SideEffectStatement]
                            )(prevSt: AwkCommand) extends CommandWithSeparator(prevSt.fs) {

  override val lineProgram: Seq[SideEffectStatement] = statements


}
