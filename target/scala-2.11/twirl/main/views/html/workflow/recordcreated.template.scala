
package views.html.workflow

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object recordcreated_Scope0 {
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

class recordcreated extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.lang.String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: java.lang.String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main()/*3.8*/ {_display_(Seq[Any](format.raw/*3.10*/("""
	 """),format.raw/*4.3*/("""<section id="appProfileCreated">
		<!-- Start Formoid form-->
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px" >
			<div class="title">
				<h2>Success</h2>
			</div>
			<div class="element-input">
				<label class="title"><span class="required"></span>"""),_display_(/*12.57*/Messages("@message")),format.raw/*12.77*/("""</label>
			</div>
			<div class="submit">
				<input type="submit" onclick="window.location.href='/'" value="Continue" />
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}))
      }
    }
  }

  def render(message:java.lang.String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((java.lang.String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object recordcreated extends recordcreated_Scope0.recordcreated
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:51 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/workflow/recordcreated.scala.html
                  HASH: aacd9eaf5c3c2eb20229120a8c2a286470b5727c
                  MATRIX: 780->1|902->28|932->33|945->39|984->41|1014->45|1464->468|1505->488
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|43->12|43->12
                  -- GENERATED --
              */
          