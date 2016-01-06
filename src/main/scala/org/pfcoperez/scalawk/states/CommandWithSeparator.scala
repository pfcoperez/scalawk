package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand

import scala.util.matching.Regex

class CommandWithSeparator private(separator: Option[String]) extends AwkCommand {

  val fs: Option[String] = separator
  override def commandOptions: Seq[String] = super.commandOptions ++ separator.map(sep => s"-F '$sep'")

  def this(separator: Regex) = this(Some(separator.toString))
  def this(separator: String) = this(Some(separator))
}
