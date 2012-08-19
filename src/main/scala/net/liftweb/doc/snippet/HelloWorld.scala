package net.liftweb.doc.snippet

import net.liftweb.http.{S, SHtml}
import net.liftweb.http.js.JsCmds
import net.liftweb.util.Helpers._

import xml.Text

class HelloWorld {
	def render = 
		"#here *" #> Text("Hello World") &
		"#click-me [onclick]" #> SHtml.ajaxInvoke{ () =>
			println("Got it!")
	      JsCmds.Alert("Got it!")
	    }
}