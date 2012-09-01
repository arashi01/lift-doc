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
      Menu("Home") / "index",
      Menu("Sitemap") / "sitemap",
      Menu("View") / "view",
      Menu("Snippet") / "snippet" >> PlaceHolder submenus (
        Menu("Lift Transformtion") / "snippet" / "transformation" / "lift",
        Menu("Scuery Transformtion") / "snippet" / "transformation" / "scuery"
      ),
      Menu("Form") / "form",
      Menu("Http") / "http",
      Menu("Javascript") / "javascript",
      Menu("Testing") / "testing",
      Menu("Deployment") / "deployment",
      Menu("Persistence") / "persistence" >> PlaceHolder submenus (
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
