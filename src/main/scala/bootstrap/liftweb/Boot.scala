package bootstrap.liftweb

import net.liftweb._
import net.liftweb.http._
import js.jquery._
import net.liftweb.sitemap._
import sitemap.Loc.{PlaceHolder, LocGroup}

import net.liftmodules.JQueryModule

class Boot {
  def boot() {

		LiftRules.addToPackages("net.liftweb.doc")
    LiftRules.addToPackages("net.liftweb.doc.guide")

    LiftRules.addToPackages("com.damianhelme.tbutils")

		val entries = List(
      Menu("Home") / "index" >> LocGroup("main"),
      Menu("Sitemap") / "sitemap" >> LocGroup("main"),
      Menu("View") / "view" >> LocGroup("main"),
      Menu("Snippet") / "snipet" >> LocGroup("main"),
      Menu("Form") / "form" >> LocGroup("main"),
      Menu("Http") / "http" >> LocGroup("main"),
      Menu("Javascript") / "javascript" >> LocGroup("main"),
      Menu("Testing") / "testing" >> LocGroup("main"),
      Menu("Deployment") / "deployment" >> LocGroup("main"),
      Menu("Persistence") / "persistence" >> LocGroup("main") >> PlaceHolder submenus (
        Menu("Record") / "persistence" / "record",
        Menu("Mapper") / "persistence" / "mapper",
        Menu("NOSQL") / "persistence" / "nosql"
      ),
      Menu("Localisation") / "localisation" >> LocGroup("main")
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
