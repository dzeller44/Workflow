
package views.html.account.reset

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ask_Scope0 {
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

class ask extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[controllers.account.Reset.AskForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(askForm: Form[controllers.account.Reset.AskForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._
implicit def /*4.6*/implicitFieldConstructor/*4.30*/ = {{
        FieldConstructor(twitterBootstrapInput.render)
    }};
Seq[Any](format.raw/*1.52*/("""

"""),format.raw/*4.1*/("""    """),format.raw/*6.6*/("""


"""),_display_(/*9.2*/main()/*9.8*/ {_display_(Seq[Any](format.raw/*9.10*/("""

	"""),format.raw/*11.2*/("""<section id="resetPassword">
		<!-- Start Formoid form-->
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>"""),_display_(/*17.10*/Messages("resetpassword")),format.raw/*17.35*/("""</h2>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Email:</label>
				<div class="item-cont">
					<input class="large" type="text" name="email" required="required"
						placeholder="Enter your email..." /><span class="icon-place"></span>
				</div>
			</div>
			<div class="submit">
				<input type="submit" value=""""),_display_(/*27.34*/Messages("reset")),format.raw/*27.51*/("""" />
				<a href="/" class="buttonCancel">"""),_display_(/*28.39*/Messages("goback")),format.raw/*28.57*/("""</a>
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>

	</section>

""")))}),format.raw/*36.2*/("""
"""))
      }
    }
  }

  def render(askForm:Form[controllers.account.Reset.AskForm]): play.twirl.api.HtmlFormat.Appendable = apply(askForm)

  def f:((Form[controllers.account.Reset.AskForm]) => play.twirl.api.HtmlFormat.Appendable) = (askForm) => apply(askForm)

  def ref: this.type = this

}


}

/**/
object ask extends ask_Scope0.ask
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/reset/ask.scala.html
                  HASH: 232da885eb8825f69367dcd43d79e599224c2363
                  MATRIX: 788->1|940->75|972->99|1068->51|1096->70|1126->165|1155->169|1168->175|1207->177|1237->180|1592->508|1638->533|2035->903|2073->920|2143->963|2182->981|2325->1094
                  LINES: 27->1|31->4|31->4|34->1|36->4|36->6|39->9|39->9|39->9|41->11|47->17|47->17|57->27|57->27|58->28|58->28|66->36
                  -- GENERATED --
              */
          