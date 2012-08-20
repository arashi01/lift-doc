package bootstrap.liftweb

import net.liftweb._
import http._
import js.jquery._
import sitemap._
import sitemap.Loc.Hidden

import net.liftmodules.JQueryModule

class Boot {
  def boot() {

		LiftRules.addToPackages("net.liftweb.doc")

		val entries = List(
      Menu("Home") / "index"
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
