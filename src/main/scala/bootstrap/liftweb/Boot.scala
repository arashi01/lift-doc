package bootstrap.liftweb

import net.liftweb._
import util._

import http._
import sitemap._

import net.liftmodules.JQueryModule
import net.liftweb.http.js.jquery._

class Boot {
  def boot() {

		LiftRules.addToPackages("net.liftweb.doc")

		val entries = List(
      Menu.i("Home") / "index"
    )

		LiftRules.setSiteMap( SiteMap(entries:_*) )

		LiftRules.early.append( _.setCharacterEncoding("UTF-8") )

		LiftRules.htmlProperties.default.set( (r: Req) =>
			new Html5Properties(r.userAgent)
		)

		LiftRules.jsArtifacts = JQueryArtifacts
		JQueryModule.InitParam.JQuery=JQueryModule.JQuery172
		JQueryModule.init()
	}
}
