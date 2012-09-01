package net.liftweb.doc.guide.snippet.transformation.builtin

import net.liftweb.util.Helpers._

class Basic {
  def render = {
    ".name *" #> "bob" &
      ".company *" #> "bob inc." &
      ".company [href]" #> "www.bob.com"
  }
}