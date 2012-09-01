package net.liftweb.doc.guide.snippet.transformation.builtin

import net.liftweb.util.Helpers._

object Selectors
{
  def render =
  {
    "#id" #> "selection by id" &
    "#child *" #> "my child" &
    "#child li *" #> "Hi child child" &
    ".my-class *" #> "my class" &
    "data-guide=my-attr *" #> "my attribute" &
    "b *" #> "tag"
  }
}