package net.liftweb.doc.guide.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.DispatchSnippet

object BasicCssSelector extends DispatchSnippet {
  def dispatch = {
    case _ => render
  }

  def render = {
    ".name *" #> "bob" &
      ".company *" #> "bob inc." &
      ".company [href]" #> "www.bob.com"
  }
}