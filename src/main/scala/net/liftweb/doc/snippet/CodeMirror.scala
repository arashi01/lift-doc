package net.liftweb.doc.snippet

import net.liftweb.http.{S, DispatchSnippet}
import net.liftweb.util.Helpers
import xml.NodeSeq

object CodeMirror extends DispatchSnippet
{
  def dispatch =
  {
    case _ => render
  }

  def show( code: NodeSeq, mode: String, label: String ) =
  {

    val guid = Helpers.nextFuncName

    <lift:children>
      <textarea id={guid}>{ code }</textarea>
      <script>
        $(function(){{
          CodeMirror.fromTextArea( document.getElementById("{guid}"), {{
            lineNumbers: true,
            readOnly: true,
            mode: "{ mode }",
            theme: "solarized-dark"
          }});
        }})
      </script>
      <label for={guid}>{ label }</label>
    </lift:children>
  }

  def render( in: NodeSeq ) = {

    val mode = "mode"

    S.attr( "mode").map( mode => {
      val label = S.attr( "label" ).openOr("")

      show( in, mode, label )
    }).openOr(
      <div class="template-error">
        <i class="icon-exclamation-sign"></i>
        { "attribute " + mode + " is not defined"}
      </div>
    )
  }
}