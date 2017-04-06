
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object badlogin_Scope0 {
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

class badlogin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/(""" """),_display_(/*1.21*/main()/*1.27*/ {_display_(Seq[Any](format.raw/*1.29*/("""

"""),format.raw/*3.1*/("""<section id="confirmEmail">
	<!-- Start Formoid form-->
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post">
		<div class="title">
			<h2>Invalid Login</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required"></span>"""),_display_(/*12.56*/message),format.raw/*12.63*/("""</label>
		</div>
		<div class="submit">
			<input type="submit" a href= """),_display_(/*15.34*/routes/*15.40*/.Application.index),format.raw/*15.58*/(""""
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

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object badlogin extends badlogin_Scope0.badlogin
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:49 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/badlogin.scala.html
                  HASH: 7fde2a8777174da6cd930b486e8ef50b24ef6d33
                  MATRIX: 751->1|863->18|891->20|905->26|944->28|972->30|1422->453|1450->460|1551->534|1566->540|1605->558|1764->687
                  LINES: 27->1|32->1|32->1|32->1|32->1|34->3|43->12|43->12|46->15|46->15|46->15|55->24
                  -- GENERATED --
              */
          