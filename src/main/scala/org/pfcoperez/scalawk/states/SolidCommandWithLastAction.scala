package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.SideEffectStatement

class SolidCommandWithLastAction(lastAction: Seq[SideEffectStatement])(prevSt: SolidCommand)
  extends SolidCommand(prevSt) {

  override val endProgram: Seq[SideEffectStatement] = lastAction

}
