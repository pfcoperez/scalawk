package org.pfcoperez.scalawk.states

import org.pfcoperez.scalawk.AwkCommand
import org.pfcoperez.scalawk.entities.{Print, SideEffectStatement, AwkElement, AwkExpression}

class SolidCommand(val lineResult: Seq[AwkExpression], prevSt: AwkCommand) extends AwkCommand
  with AwkElement { //This is the first state which can be used to obtain an AWK command string `toAwk`

  def this(prev: AwkCommand) = this(prev.linePresentation , prev)
  //def this(line: Seq[AwkExpression])(prev: AwkCommand) = this(line, prev)

  override val commandOptions: Seq[String] = prevSt.commandOptions
  override val linePresentation: Seq[AwkExpression] = lineResult
  override val lineProgram: Seq[SideEffectStatement] = prevSt.lineProgram


  // AWK Program sections

  // BEGIN
  protected def beginBlock: String = programToBlock(initialProgram)

  // Per-line
  protected def eachLineActionBlock: String =
    programToBlock(lineProgram :+ Print(linePresentation))


  // END
  protected def endBlock: String = programToBlock(endProgram)

  protected def programToBlock(program: Seq[SideEffectStatement]) =
    {program.map(_.toAwk) mkString "; "} +
      program.headOption.map(_ => "; ").getOrElse("")

  protected def optionsBlock: String =
    {commandOptions mkString " "} + commandOptions.headOption.map(_ => " ").getOrElse("")

  override def toAwk: String =
    s"""|awk ${optionsBlock}'
        |${identifyBlock("BEGIN", beginBlock)}
        |${identifyBlock("", eachLineActionBlock)}
        |${identifyBlock("END", endBlock)}'""".stripMargin.replace("\n", "")

  //Auxialiary methods
  private[this] def identifyBlock(blockName: String, blockAwkCode: String): String =
    blockAwkCode.headOption.map(_ => s"$blockName{$blockAwkCode}").getOrElse("")

}
