package net.liftweb.doc.snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.{LiftRules, Templates, S, DispatchSnippet}
import net.liftweb.common.{Failure, Full}

import scala.xml.Text

object CodeInjection extends DispatchSnippet
{
  val attr = "what"

  def dispatch = {
    case _ => render
  }

  def render = {

    "*" #> { openTemplate match {
      case Full( code ) => {
        fileName match {
          case "scala" => <pre> { code } </pre>
          case "html" => <pre> { code } </pre>
          case _ => <pre> { code } </pre>
        }
      }
      case Failure( msg, _, _ ) => {
        Text( msg )
      }
      case _ => {
        Text("huh ?")
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

  def fileName =
  {
    val path = S.attr( attr ).openOrThrowException( attr + " should not be empty" )

    path.split('.').last
  }
}
