
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object exportready_Scope0 {
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

class exportready extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(downloadLocation: String, userRole: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.46*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

"""),format.raw/*5.1*/("""<section id="exportLocation">
	<form id="showuser" class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action=""""),_display_(/*8.26*/routes/*8.32*/.Application.exportOpenFile(downloadLocation)),format.raw/*8.77*/("""">
		<div class="title">
			<h2>Export Data Location</h2>
		</div>
		<div class="element-input">
			<label class="title"><span></span>Your export file has been saved to the location below.</label>
		</div>	
		<div class="element-input">
			<label class="title">"""),_display_(/*16.26*/downloadLocation),format.raw/*16.42*/("""</label>
		</div>				
		<div class="submit">
			<input type="submit" value="Open File" />
			<a href="/"""),_display_(/*20.15*/userRole),format.raw/*20.23*/("""" class="buttonCancel">"""),_display_(/*20.47*/Messages("goback")),format.raw/*20.65*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>

</section>

""")))}))
      }
    }
  }

  def render(downloadLocation:String,userRole:String): play.twirl.api.HtmlFormat.Appendable = apply(downloadLocation,userRole)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (downloadLocation,userRole) => apply(downloadLocation,userRole)

  def ref: this.type = this

}


}

/**/
object exportready extends exportready_Scope0.exportready
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:49 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/exportready.scala.html
                  HASH: 6fbdbd02648b4f8472e571b1b0bdd5b35175cc98
                  MATRIX: 764->1|903->45|933->50|951->60|990->62|1020->66|1326->346|1340->352|1405->397|1702->667|1739->683|1874->791|1903->799|1954->823|1993->841
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|39->8|39->8|39->8|47->16|47->16|51->20|51->20|51->20|51->20
                  -- GENERATED --
              */
          