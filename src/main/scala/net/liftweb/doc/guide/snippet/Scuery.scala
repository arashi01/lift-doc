package net.liftweb.doc.guide.snippet

import net.liftweb.http.DispatchSnippet

import org.fusesource.scalate.scuery.Transformer
import xml.NodeSeq

object Scuery extends DispatchSnippet {
  def dispatch = {
    case _ => render
  }

  def render( x: NodeSeq ): NodeSeq = transformer( x )

  object transformer extends Transformer {
    $(".name").contents = "bob"
    $(".company").contents = "bob inc."
    $(".company").attribute("href").value = "http://www.bob.com"
  }
}
