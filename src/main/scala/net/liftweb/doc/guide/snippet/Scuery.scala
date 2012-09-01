package net.liftweb.doc.guide.snippet

import org.fusesource.scalate.scuery.Transformer
import xml.NodeSeq

class Scuery
{
  def render( x: NodeSeq ): NodeSeq = transformer( x )

  object transformer extends Transformer {
    $(".name").contents = "bob"
    $(".company").contents = "bob inc."
    $(".company").attribute("href").value = "http://www.bob.com"
  }
}
