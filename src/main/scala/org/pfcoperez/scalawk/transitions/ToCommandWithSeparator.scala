package org.pfcoperez.scalawk.transitions

import org.pfcoperez.scalawk.states.CommandWithSeparator

import scala.util.matching.Regex

trait ToCommandWithSeparator {

  def splitted = new {
      def by(separator: String): CommandWithSeparator = null
      def by(separator: Regex): CommandWithSeparator = null
      def by = new {
        // https://www.gnu.org/software/gawk/manual/html_node/Default-Field-Splitting.html#Default-Field-Splitting
        def blankSequence: CommandWithSeparator = null
      }


    }

}
