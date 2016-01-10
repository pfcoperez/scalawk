package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.states.CommandWithSeparator

import scala.util.matching.Regex

object ToCommandWithSeparator {
  implicit def toCommandWithSep(x: ToCommandWithSeparator) = new CommandWithSeparator()
}

trait ToCommandWithSeparator {

  def splittedBy(separator: String) = new CommandWithSeparator(separator)
  def splittedBy(separator: Regex) =  new CommandWithSeparator(separator)

}
