import net.liftweb.util.Helpers._

class BasicCssSelector
{
  def render = {
    ".name *" #> "bob" &
    ".company *" #> "bob inc." &
    ".company [href]" #> "http://www.bob.com"
  }
}