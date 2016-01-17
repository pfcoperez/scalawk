package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.AwkExpression
import org.pfcoperez.scalawk.states.SolidCommand

trait ToSolidCommand {
  self: AwkCommand =>

  def arePresentedAs(printElements: AwkExpression*): SolidCommand =
    //new SolidCommand(printElements)(self)
    new SolidCommand(printElements, self)

}
