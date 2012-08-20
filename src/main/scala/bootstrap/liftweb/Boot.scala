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
      Menu("Home") / "index",
      Menu("Interactive Stuff") / "interactive" submenus(
        Menu("Comet Chat") / "chat" >> Hidden,
        Menu("Ajax Samples") / "ajax",
        Menu("Ajax Form") / "ajax-form",
        Menu("Modal Dialog") / "rhodeisland",
        Menu("JSON Messaging") / "json",
        Menu("Stateless JSON Messaging") / "stateless_json",
        Menu("More JSON") / "json_more",
        Menu("Ajax and Forms") / "form_ajax") ,
      Menu("Persistence") / "persistence" >> Hidden submenus (
        Menu("XML Fun") / "xml_fun" >> Hidden,
        Menu("Database") / "database" >> Hidden,
        Menu("Templates") / "template" >> Hidden),
      Menu("Templating") / "templating" / "index" submenus(
        Menu("Surround") / "templating" / "surround",
        Menu("Embed") / "templating" / "embed",
        Menu("Evalutation Order") / "templating" / "eval_order",
        Menu("Select <div>s") / "templating" / "selectomatic",
        Menu("Simple Wizard") / "simple_wizard",
        Menu("Lazy Loading") / "lazy",
        Menu("Parallel Snippets") / "parallel",
        Menu("<head/> tag") / "templating"/ "head"),
      Menu("Web Services") / "ws" >> Hidden,
      Menu("Localization") / "lang"
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
