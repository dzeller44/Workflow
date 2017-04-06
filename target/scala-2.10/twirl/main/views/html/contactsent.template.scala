
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object contactsent_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class contactsent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""


	"""),_display_(/*4.3*/main()/*4.9*/ {_display_(Seq[Any](format.raw/*4.11*/("""

	"""),format.raw/*6.2*/("""<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post">
		<div class="title">
			<h2>Message Sent</h2>
		</div>
		<div class="element-input">
			<label class="title">Your message has been sent to the CO-Assist admin. You will also receive a copy at the email provided.<label><span><br /></span>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>


""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object contactsent extends contactsent_Scope0.contactsent
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/contactsent.scala.html
                  HASH: 4d97445639faa5aa76467de766113043ec21d414
                  MATRIX: 750->1|846->3|879->11|892->17|931->19|962->24
                  LINES: 27->1|32->1|35->4|35->4|35->4|37->6
                  -- GENERATED --
              */
          