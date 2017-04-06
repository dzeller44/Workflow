
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object editlookup_Scope0 {
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

class editlookup extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[java.util.List[Lookup],Lookup,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(lookups: java.util.List[Lookup], currentLookup: Lookup):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.58*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

	"""),format.raw/*5.2*/("""<section id="newLookup">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Lookup</h2>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Lookup Type:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="lookuptype" required="required">
								<option value="" disabled="disabled">--- Select Type ---</option>
									"""),_display_(/*19.11*/for(lookup <- lookups) yield /*19.33*/ {_display_(Seq[Any](format.raw/*19.35*/("""
			                  			"""),_display_(/*20.26*/if(lookup.lookuptype == "ControlTypeList")/*20.68*/ {_display_(Seq[Any](format.raw/*20.70*/("""<option """),_display_(/*20.79*/if(lookup.name == currentLookup.lookuptype)/*20.122*/ {_display_(Seq[Any](format.raw/*20.124*/("""selected="selected"""")))}),format.raw/*20.144*/(""" """),format.raw/*20.145*/("""value=""""),_display_(/*20.153*/lookup/*20.159*/.name),format.raw/*20.164*/("""">"""),_display_(/*20.167*/lookup/*20.173*/.name),format.raw/*20.178*/("""</option>""")))}),format.raw/*20.188*/("""
									""")))}),format.raw/*21.11*/("""
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
						placeholder="Enter the Lookup Title/Name..." value=""""),_display_(/*33.60*/currentLookup/*33.73*/.name),format.raw/*33.78*/("""" /><span class="icon-place"></span>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span></span>Description:</label>
				<div class="item-cont">
					<input class="large" type="text" name="description"
						placeholder="Enter the description..." value=""""),_display_(/*40.54*/currentLookup/*40.67*/.description),format.raw/*40.79*/("""" /><span class="icon-place"></span>
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

  def render(lookups:java.util.List[Lookup],currentLookup:Lookup): play.twirl.api.HtmlFormat.Appendable = apply(lookups,currentLookup)

  def f:((java.util.List[Lookup],Lookup) => play.twirl.api.HtmlFormat.Appendable) = (lookups,currentLookup) => apply(lookups,currentLookup)

  def ref: this.type = this

}


}

/**/
object editlookup extends editlookup_Scope0.editlookup
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/editlookup.scala.html
                  HASH: da4bddc5cd6ca95661382bd0fa152ad1c321fe72
                  MATRIX: 784->1|935->57|963->60|981->70|1020->72|1049->75|1705->704|1743->726|1783->728|1836->754|1887->796|1927->798|1963->807|2016->850|2057->852|2109->872|2139->873|2175->881|2191->887|2218->892|2249->895|2265->901|2292->906|2334->916|2376->927|2412->936|2885->1382|2907->1395|2933->1400|3246->1686|3268->1699|3301->1711|3497->1880|3536->1898|3677->2009
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|51->20|52->21|53->22|64->33|64->33|64->33|71->40|71->40|71->40|76->45|76->45|82->51
                  -- GENERATED --
              */
          