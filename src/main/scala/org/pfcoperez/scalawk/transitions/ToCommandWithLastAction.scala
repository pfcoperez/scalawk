package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.entities.SideEffectStatement
import org.pfcoperez.scalawk.states.{SolidCommandWithLastAction, SolidCommand}

trait ToCommandWithLastAction {
  self: SolidCommand =>

  def finallyDo(lastAction: SideEffectStatement*): SolidCommandWithLastAction =
    new SolidCommandWithLastAction(lastAction)(self)

}
