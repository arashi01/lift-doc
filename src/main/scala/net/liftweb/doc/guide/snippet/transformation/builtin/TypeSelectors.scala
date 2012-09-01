package net.liftweb.doc.guide.snippet.transformation.builtin

import net.liftweb.util.Helpers._

object TypeSelectors
{
  def render =
  {
    "@name [value]" #> "bob" &
    ":button [value]" #> "bob" &
    ":checkbox [checked]" #> "checked" &
    ":file [class]" #> "hidden" &
    ":password [placeholder]" #> "password" &
    "value=hard [checked]" #> "" &  //:radio name=difficulty
    "value=easy [checked]" #> "checked" & // :radio name=difficulty
    ":text [value]" #> "a" &
    ":reset [disabled]" #> "disabled" &
    ":submit [disabled]" #> "disabled"
  }
}
