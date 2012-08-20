package bootstrap.liftweb

import net.liftweb._
import http.Html5Properties
import net.liftweb.http._
import js.jquery._
import net.liftweb.sitemap._
import sitemap.Loc.{PlaceHolder, LocGroup, Hidden}

import net.liftmodules.JQueryModule

class Boot {
  def boot() {

		LiftRules.addToPackages("net.liftweb.doc")
    LiftRules.addToPackages("com.damianhelme.tbutils")

		val entries = List(
      Menu("Home") / "index" >> LocGroup("main"),
      Menu("View") / "view" >> LocGroup("main") >> PlaceHolder submenus (
        Menu("Surround") / "view" / "surround",
        Menu("Embed") / "view" / "embed",
        Menu("Head & Tail") / "view"/ "headtail",
        Menu("Evalutation Order") / "view" / "eval_order"
      ),
      Menu("Snipet") / "snipet" >> LocGroup("main") >> PlaceHolder submenus (
        Menu("Lazy Loading") / "snipet" / "lazy",
        Menu("Parallel") / "snipet" / "parallel"
      )
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
