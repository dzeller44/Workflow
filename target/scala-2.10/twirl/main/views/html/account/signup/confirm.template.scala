
package views.html.account.signup

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object confirm_Scope0 {
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

class confirm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main()/*1.8*/ {_display_(Seq[Any](format.raw/*1.10*/("""

"""),format.raw/*3.1*/("""<section id="confirmEmail">
	<!-- Start Formoid form-->
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px">
		<div class="title">
			<h2>Account Activated</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required"></span>"""),_display_(/*11.56*/Messages("signup.signup")),format.raw/*11.81*/("""
				"""),format.raw/*12.5*/("""- """),_display_(/*12.8*/Messages("signup.email.confirmed")),format.raw/*12.42*/("""</label>
		</div>
		<div class="submit">
			<input type="submit" onclick="window.location.href='/'"
				value="Continue" />
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>

</section>

""")))}),format.raw/*24.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object confirm extends confirm_Scope0.confirm
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/signup/confirm.scala.html
                  HASH: e1e2962966e91bac35ea29b7179d8a1c3369b37f
                  MATRIX: 846->1|859->7|898->9|926->11|1364->422|1410->447|1442->452|1471->455|1526->489|1783->716
                  LINES: 32->1|32->1|32->1|34->3|42->11|42->11|43->12|43->12|43->12|55->24
                  -- GENERATED --
              */
          