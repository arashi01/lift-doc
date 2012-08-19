package net.liftweb.doc

import org.scalatest._
	import matchers.ShouldMatchers._
	import selenium._
		import HtmlUnit.webDriver
		import WebBrowser._

import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver

class LoginSpec
	extends JettySpec 
	with ShouldMatchers
	with Firefox
{
	describe( "login" )
	{
		it("should authorize a user with correct credentials")
		{
			go to ( host )
		}
	}
}