
package views.html.workflow

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object recordupdated_Scope0 {
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

class recordupdated extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.lang.String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: java.lang.String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main()/*3.8*/ {_display_(Seq[Any](format.raw/*3.10*/("""
"""),format.raw/*4.1*/("""<section id="intakeUpdated">
	<!-- Start Formoid form-->
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px">
		<div class="title">
			<h2>Success</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required"></span>"""),_display_(/*12.56*/Messages("@message")),format.raw/*12.76*/("""</label>
		</div>
		<div class="submit">
			<input type="submit" onclick="window.location.href='/'"	value="Continue" />
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>
</section>
""")))}),format.raw/*21.2*/("""
"""))
      }
    }
  }

  def render(message:java.lang.String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((java.lang.String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object recordupdated extends recordupdated_Scope0.recordupdated
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/workflow/recordupdated.scala.html
                  HASH: 6937764441a890cd1df95bb765be2bc5440172a0
                  MATRIX: 780->1|902->28|932->33|945->39|984->41|1012->43|1449->453|1490->473|1750->703
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|43->12|43->12|52->21
                  -- GENERATED --
              */
          