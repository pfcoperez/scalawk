package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.{AwkElement, AwkExpression}

class SolidCommand(val lineResult: Seq[AwkExpression])(prevSt: AwkCommand) extends AwkCommand
  with AwkElement { //This is the first state which can be used to obtain an AWK command string `toAwk`

  override val commandOptions: Seq[String] = prevSt.commandOptions
  override def linePresentation: Seq[AwkExpression] = lineResult


  // AWK Program sections

  // BEGIN
  protected def beginBlock: String = ""

  // Per-line
  protected def eachLineActionBlock: String = "print " + { linePresentation.map(_.toAwk) mkString ""}

  // END
  protected def endBlock: String = ""

  protected def optionsBlock: String = commandOptions mkString " "

  override def toAwk: String =
    s"""|awk ${optionsBlock} '
        |${identifyBlock("BEGIN", beginBlock)}
        |${identifyBlock("", eachLineActionBlock)}
        |${identifyBlock("END", endBlock)}'""".stripMargin.replace("\n", "")

  //Auxialiary methods
  private[this] def identifyBlock(blockName: String, blockAwkCode: String): String =
    blockAwkCode.headOption.map(_ => s"$blockName{$blockAwkCode}").getOrElse("")

}
