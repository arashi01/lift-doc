package net.liftweb.doc.guide.snippet.transformation.scuery

import org.fusesource.scalate.scuery.Transformer
import xml.NodeSeq

object Scuery
{
  def render(x: NodeSeq): NodeSeq = transformer(x)

  object transformer extends Transformer
  {
    $(".name").contents = "bob"
    $(".company").contents = "bob inc."
    $(".company").attribute("href").value = "http://www.bob.com"
  }
}
