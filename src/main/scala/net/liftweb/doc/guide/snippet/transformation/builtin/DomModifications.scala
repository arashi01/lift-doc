package net.liftweb.doc.guide.snippet.transformation.builtin

import net.liftweb.util.Helpers._

object DomModifications
{
  def render =
  {(
    "#insert *+" #> "After" &
    "#insert -*" #> "Before" &

    "#hyperlink [href]" #> "http://www.google.com" &
    "#lift [class!]" #> "hard" &
    "#lift [class+]" #> "easy"
  )}
}