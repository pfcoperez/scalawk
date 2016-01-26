package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.transitions.{ToCommandWithInitialProgram, ToCommandWithLineProgram, ToSolidCommand}

import scala.util.matching.Regex

// https://www.gnu.org/software/gawk/manual/html_node/Default-Field-Splitting.html#Default-Field-Splitting
class CommandWithSeparator(separator: Option[String] = None) extends AwkCommand
  with ToSolidCommand
  with ToCommandWithLineProgram
  with ToCommandWithInitialProgram {

  override val commandOptions: Seq[String] = separator.map(sep => s"-F '$sep'").toSeq

  def this(separator: Regex) = this(Some(separator.toString))
  def this(separator: String) = this(Some(separator))

}
