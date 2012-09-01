package net.liftweb.doc.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.{LiftRules, S, DispatchSnippet}
import net.liftweb.common.{Empty, Failure, Full}

import xml.{NodeSeq, Elem, Text}
import net.liftweb.util.Helpers


object CodeInjection extends DispatchSnippet
{
  val attr = "what"

  def dispatch = {
    case _ => render
  }

  def render = {

    "*" #> { openTemplate match {
      case Full( ( code, fileName, fileExtension ) ) => {
        fileExtension match {
          case "scala" => renderCodeMirror( Text( code ), fileName, fileExtension )
          case "html" => renderCodeMirror( Text( code ), fileName, fileExtension )
          case _ => <pre> { code } </pre>
        }
      }
      case Failure( msg, _, _ ) => {
        <div class="template-error">
          <i class="icon-exclamation-sign"></i>
          {
            msg
          }
        </div>
      }
      case _ => {
			<div class="template-error">
				<i class="icon-exclamation-sign"></i>
	          Empty
			</div>
      }
    }}
  }

  def openTemplate =
  {
    for {
      path <- S.attr( attr ) ?~ ( "attr: " + attr + " is not defined" )
		  fileName <- Full( path.split('/').last ) ?~ ( "cannot parse a filename: " + path )
		  fileExtension <- Full( fileName.split('.').last ) ?~ ( "cannot parse a file extension: " + fileName )
      code <- LiftRules.loadResourceAsString( path ) ?~ ( "template: " + path + " not found" )
    } yield ( code, fileName, fileExtension )
  }

  def renderCodeMirror( code: NodeSeq, fileName: String, fileExtension: String ) : Elem = {

    val mode = fileExtension match {
      case "scala" => "text/x-scala"
      case "html" => "text/html"
    }

    CodeMirror.show( code, mode, label = fileName )
  }
}
