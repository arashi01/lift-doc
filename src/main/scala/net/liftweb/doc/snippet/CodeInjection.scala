package net.liftweb.doc.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.{LiftRules, S, DispatchSnippet}
import net.liftweb.common.{Empty, Failure, Full}

import xml.{Elem, Text}
import net.liftweb.util.Helpers


object CodeInjection extends DispatchSnippet
{
  val attr = "what"

  def dispatch = {
    case _ => render
  }

  def render = {

    "*" #> { openTemplate match {
      case Full( code ) => {
        fileExtension match {
          case "scala" => renderCodeMirror( code )
          case "html" => renderCodeMirror( code )
          case _ => <pre> { code } </pre>
        }
      }
      case Failure( msg, _, _ ) => {
        Text( msg )
      }
      case _ => {
        <div class="template-error">
          <i class="icon-exclamation-sign"></i>
          {
            S.attr( attr ).
              map( x => "template: " + x + " not found" ).
              openOr( "attr: " + attr + " is not defined" )
          }
        </div>
      }
    }}
  }

  def openTemplate =
  {
    for {
      path <- S.attr( attr )
      code <- LiftRules.loadResourceAsString( path )
    } yield code
  }

  def fileExtension =
  {
    path.split('.').last
  }

  def path =
  {
    S.attr( attr ).openOrThrowException( attr + " should not be empty" )
  }

  def fileName =
  {
    path.split("/").last
  }

  def renderCodeMirror( code: String ) : Elem = {

    val guid = Helpers.nextFuncName

    val mode = fileExtension match {
      case "scala" => "text/x-scala"
      case "html" => "text/html"
    }

    <lift:children>
      <textarea id={guid}>{code}</textarea>
      <script>
        $(function(){{
          CodeMirror.fromTextArea( document.getElementById("{guid}"), {{
            lineNumbers: true,
            readOnly: true,
            mode: "{mode}",
            theme: "solarized-dark"
          }})
        }})
      </script>
      <label for={guid}>{ fileName }</label>
    </lift:children>
  }
}
