package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.states.CommandWithSeparator

import scala.util.matching.Regex

object ToCommandWithSeparator {
  implicit def toCommandWithSep(x: ToCommandWithSeparator) = new CommandWithSeparator()
}

trait ToCommandWithSeparator {

  def splitBy(separator: String) = new CommandWithSeparator(separator)
  def splitBy(separator: Regex) =  new CommandWithSeparator(separator)

}
