
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object export_Scope0 {
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

class export extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(reportType: String, downloadLocation: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.48*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

"""),format.raw/*5.1*/("""<section id="exportLocation">
<form id="showuser" class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action=""""),_display_(/*8.26*/routes/*8.32*/.Application.updateUser()),format.raw/*8.57*/("""">
		<div class="title">
			<h2>Export Data Location</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>Export To:</label>
			<div class="item-cont">
				<input class="large" type="text" name="exportLocation" required="required" 
					placeholder="Choose a location..." value="""),_display_(/*16.48*/downloadLocation),format.raw/*16.64*/(""" """),format.raw/*16.65*/("""/><span class="icon-place"></span>
			</div>
		</div>  				
		<div class="submit">
			<input type="submit" value="""),_display_(/*20.32*/Messages("submit")),format.raw/*20.50*/(""" """),format.raw/*20.51*/("""/>
			<a href="/admin" class="buttonCancel">"""),_display_(/*21.43*/Messages("goback")),format.raw/*21.61*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>

</section>

""")))}))
      }
    }
  }

  def render(reportType:String,downloadLocation:String): play.twirl.api.HtmlFormat.Appendable = apply(reportType,downloadLocation)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (reportType,downloadLocation) => apply(reportType,downloadLocation)

  def ref: this.type = this

}


}

/**/
object export extends export_Scope0.export
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/export.scala.html
                  HASH: bf8d2e25e155d262327361af77cc0e366cd1a200
                  MATRIX: 754->1|895->47|925->52|943->62|982->64|1012->68|1317->347|1331->353|1376->378|1736->711|1773->727|1802->728|1947->846|1986->864|2015->865|2088->911|2127->929
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|39->8|39->8|39->8|47->16|47->16|47->16|51->20|51->20|51->20|52->21|52->21
                  -- GENERATED --
              */
          