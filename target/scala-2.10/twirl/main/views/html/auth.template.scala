
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object auth_Scope0 {
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

class auth extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Application.Login],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[Application.Login]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._
implicit def /*4.2*/implicitFieldConstructor/*4.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq[Any](format.raw/*1.38*/("""

"""),format.raw/*4.80*/("""

"""),_display_(/*6.2*/main(null)/*6.12*/ {_display_(Seq[Any](format.raw/*6.14*/("""

"""),format.raw/*8.1*/("""<section id="authentication">
	<!-- Start Formoid form-->
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action="">

		<div class="title">
			<h2>Login</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>Email:</label>
			<div class="item-cont">
				<input class="large" type="text" name="email" required="required"
					placeholder="Enter your email..." /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-password">
			<label class="title"><span class="required">*</span>Password:</label>
			<div class="item-cont">
				<input class="large" type="password" name="password" value=""
					required="required" placeholder="Enter your password..." /><span
					class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
		    """),_display_(/*33.8*/if(loginForm.hasGlobalErrors)/*33.37*/ {_display_(Seq[Any](format.raw/*33.39*/("""
        		"""),format.raw/*34.11*/("""<span class="errorMessageDisplay" style="color: #d9534f;">
            		"""),_display_(/*35.16*/loginForm/*35.25*/.globalError.message),format.raw/*35.45*/("""
        		"""),format.raw/*36.11*/("""</span>
   			""")))}),format.raw/*37.8*/("""
		"""),format.raw/*38.3*/("""</div>
		<div class="submit">
			<input type="submit" value="Submit" />
			<a href="/" class="buttonCancel">"""),_display_(/*41.38*/Messages("goback")),format.raw/*41.56*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>

	<div class="loginBlock">
		<a href="/signup"><div class="loginText">"""),_display_(/*48.45*/Messages("account.need")),format.raw/*48.69*/("""</div></a>
		<a href="/reset/ask"><div class="loginText">"""),_display_(/*49.48*/Messages("forgot.password")),format.raw/*49.75*/("""</div></a>
	</div>

</section>

""")))}),format.raw/*54.2*/("""
"""))
      }
    }
  }

  def render(loginForm:Form[Application.Login]): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)

  def f:((Form[Application.Login]) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)

  def ref: this.type = this

}


}

/**/
object auth extends auth_Scope0.auth
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/auth.scala.html
                  HASH: c33648c5f4b2399e0eaf767d66a9ab487e617adf
                  MATRIX: 760->1|898->60|930->84|1014->37|1045->138|1075->143|1093->153|1132->155|1162->159|2203->1174|2241->1203|2281->1205|2321->1217|2423->1292|2441->1301|2482->1321|2522->1333|2568->1349|2599->1353|2738->1465|2777->1483|2976->1655|3021->1679|3107->1738|3155->1765|3223->1803
                  LINES: 27->1|31->4|31->4|32->1|34->4|36->6|36->6|36->6|38->8|63->33|63->33|63->33|64->34|65->35|65->35|65->35|66->36|67->37|68->38|71->41|71->41|78->48|78->48|79->49|79->49|84->54
                  -- GENERATED --
              */
          