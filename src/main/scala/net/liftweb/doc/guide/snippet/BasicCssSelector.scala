package net.liftweb.doc.guide.snippet

import net.liftweb.util.Helpers._

class BasicCssSelector
{
  def render = {
    ".name *" #> "bob" &
      ".company *" #> "bob inc." &
      ".company [href]" #> "www.bob.com"
  }
}