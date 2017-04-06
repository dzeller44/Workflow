
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object lookup_Scope0 {
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

class lookup extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.util.List[Lookup],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(lookups: java.util.List[Lookup]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.35*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

	"""),format.raw/*5.2*/("""<section id="newLookup">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>New Lookup</h2>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Lookup Type:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="lookuptype" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Type ---</option>
								"""),_display_(/*19.10*/for(lookup <- lookups) yield /*19.32*/ {_display_(Seq[Any](format.raw/*19.34*/("""
									"""),_display_(/*20.11*/if(lookup.lookuptype == "ControlTypeList")/*20.53*/ {_display_(Seq[Any](format.raw/*20.55*/("""<option value=""""),_display_(/*20.71*/lookup/*20.77*/.name),format.raw/*20.82*/("""">"""),_display_(/*20.85*/lookup/*20.91*/.name),format.raw/*20.96*/("""</option>""")))}),format.raw/*20.106*/("""
								""")))}),format.raw/*21.10*/("""
								"""),format.raw/*22.9*/("""<option value="ControlTypeList" disabled="disabled">ControlTypeList</option>
							</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Name:</label>
				<div class="item-cont">
					<input class="large" type="text" name="name" required="required"
						placeholder="Enter the Lookup Title/Name..." /><span class="icon-place"></span>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span></span>Description:</label>
				<div class="item-cont">
					<input class="large" type="text" name="description"
						placeholder="Enter the description..." /><span class="icon-place"></span>
				</div>
			</div>
			<div class="submit">
				<input type="submit" value="Submit" /> <a href="/admin"
					class="buttonCancel">"""),_display_(/*45.28*/Messages("goback")),format.raw/*45.46*/("""</a>
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}),format.raw/*51.2*/("""
"""))
      }
    }
  }

  def render(lookups:java.util.List[Lookup]): play.twirl.api.HtmlFormat.Appendable = apply(lookups)

  def f:((java.util.List[Lookup]) => play.twirl.api.HtmlFormat.Appendable) = (lookups) => apply(lookups)

  def ref: this.type = this

}


}

/**/
object lookup extends lookup_Scope0.lookup
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/lookup.scala.html
                  HASH: 03fba4a0cec8b700083bcce97720fe6c0e2f31c3
                  MATRIX: 769->1|897->34|925->37|943->47|982->49|1011->52|1690->704|1728->726|1768->728|1806->739|1857->781|1897->783|1940->799|1955->805|1981->810|2011->813|2026->819|2052->824|2094->834|2135->844|2171->853|3079->1734|3118->1752|3259->1863
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|52->21|53->22|76->45|76->45|82->51
                  -- GENERATED --
              */
          