
package views.html.account.reset

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object runAsk_Scope0 {
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

     object runAsk_Scope1 {
import helper._

class runAsk extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

implicit def /*2.2*/implicitFieldConstructor/*2.26*/ = {{
    FieldConstructor(twitterBootstrapInput.render)
}};
Seq[Any](format.raw/*4.2*/("""

"""),_display_(/*6.2*/main()/*6.8*/ {_display_(Seq[Any](format.raw/*6.10*/("""

"""),format.raw/*8.1*/("""<section id="resetPasswordSuccesss">
	<!-- Start Formoid form-->
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action="">
		<div class="title">
			<h2>"""),_display_(/*14.9*/Messages("resetpassword")),format.raw/*14.34*/("""</h2>
		</div>
		<div class="element-input">
			<label class="title"><span></span>"""),_display_(/*17.39*/Messages("resetpassword.mailsent")),format.raw/*17.73*/("""</label>
		</div>
		<div class="submit">
			<a href="/" class="buttonCancel">"""),_display_(/*20.38*/Messages("goback")),format.raw/*20.56*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>

</section>

""")))}),format.raw/*28.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}
}

/**/
object runAsk extends runAsk_Scope0.runAsk_Scope1.runAsk
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/reset/runAsk.scala.html
                  HASH: 4b7c48e9c6096571ed5ea16f43ab6f79dcbcc6c1
                  MATRIX: 881->18|913->42|1000->100|1028->103|1041->109|1080->111|1108->113|1464->443|1510->468|1620->551|1675->585|1780->663|1819->681|1957->789
                  LINES: 34->2|34->2|37->4|39->6|39->6|39->6|41->8|47->14|47->14|50->17|50->17|53->20|53->20|61->28
                  -- GENERATED --
              */
          