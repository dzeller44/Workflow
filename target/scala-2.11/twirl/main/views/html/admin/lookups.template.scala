
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object lookups_Scope0 {
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

class lookups extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.util.List[Lookup],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(lookups: java.util.List[Lookup]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.35*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

	"""),format.raw/*5.2*/("""<script src=""""),_display_(/*5.16*/routes/*5.22*/.Assets.at("js/jquery/jquery-latest.js")),format.raw/*5.62*/("""" type="text/javascript"></script>
	<script src=""""),_display_(/*6.16*/routes/*6.22*/.Assets.at("js/jquery/jquery.tablesorter.js")),format.raw/*6.67*/("""" type="text/javascript"></script>
	<link href=""""),_display_(/*7.15*/routes/*7.21*/.Assets.at("css/tablesort.css")),format.raw/*7.52*/("""" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function() """),format.raw/*9.32*/("""{"""),format.raw/*9.33*/("""
			"""),format.raw/*10.4*/("""$("#tableAll").tablesorter();
			$(".selectFirstField").change(function() """),format.raw/*11.45*/("""{"""),format.raw/*11.46*/("""
				"""),format.raw/*12.5*/("""getLookupByType();
			"""),format.raw/*13.4*/("""}"""),format.raw/*13.5*/(""");
		"""),format.raw/*14.3*/("""}"""),format.raw/*14.4*/(""");
	</script>
	<section id="displayResults" style="padding: 30px;">	
		<div class="table-responsive">
			<h5>All Lookups:</h5>
			<div class="container">
				<div class="row" style="margin: auto;">
					<div class="col-md-4">
					<a href="/addlookup" class="buttonCustomView" style="color: #FFFFFF;">Add New Lookup</a>
					</div>
					<div class="col-sm-4">
						<div class="element-select">
							<div class="selectDropdownField">
								<div class="medium">
									<span>
										<select class="selectFirstField" name="selectFirstField" id="selectFirstField">
											<option selected="selected" value="" disabled="disabled">--- Filter By Type ---</option>
											<option value="All">All</option>
											"""),_display_(/*32.13*/for(lookup <- lookups) yield /*32.35*/ {_display_(Seq[Any](format.raw/*32.37*/("""
												"""),_display_(/*33.14*/if(lookup.lookuptype == "ControlTypeList")/*33.56*/ {_display_(Seq[Any](format.raw/*33.58*/("""<option value=""""),_display_(/*33.74*/lookup/*33.80*/.name),format.raw/*33.85*/("""">"""),_display_(/*33.88*/lookup/*33.94*/.name),format.raw/*33.99*/("""</option>""")))}),format.raw/*33.109*/("""
											""")))}),format.raw/*34.13*/("""	
										"""),format.raw/*35.11*/("""</select>
										<i></i><span class="iconPlacement"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-1"></div>
				</div>
			</div>
			<table id="tableAll" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
				<thead>
					<tr>
						<th>Type</th>
						<th>Name</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					"""),_display_(/*55.7*/for(lookup <- lookups) yield /*55.29*/ {_display_(Seq[Any](format.raw/*55.31*/("""
					"""),format.raw/*56.6*/("""<tr>
						<td><a href="/openlookup/"""),_display_(/*57.33*/lookup/*57.39*/.lookupkey),format.raw/*57.49*/("""">"""),_display_(/*57.52*/lookup/*57.58*/.lookuptype),format.raw/*57.69*/("""</a></td>
						<td><a href="/openlookup/"""),_display_(/*58.33*/lookup/*58.39*/.lookupkey),format.raw/*58.49*/("""">"""),_display_(/*58.52*/lookup/*58.58*/.name),format.raw/*58.63*/("""</a></td>
						<td><a href="/openlookup/"""),_display_(/*59.33*/lookup/*59.39*/.lookupkey),format.raw/*59.49*/("""">"""),_display_(/*59.52*/lookup/*59.58*/.description),format.raw/*59.70*/("""</a></td>
					</tr>
					""")))}),format.raw/*61.7*/(""" 
				"""),format.raw/*62.5*/("""</tbody>
			</table>
		</div>
		<div><a href="/exportusers/All" class="buttonCustomView" style="color: #FFFFFF;">Export This View</a></div>
	</section>
""")))}))
      }
    }
  }

  def render(lookups:java.util.List[Lookup]): play.twirl.api.HtmlFormat.Appendable = apply(lookups)

  def f:((java.util.List[Lookup]) => play.twirl.api.HtmlFormat.Appendable) = (lookups) => apply(lookups)

  def ref: this.type = this

}


}

/**/
object lookups extends lookups_Scope0.lookups
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/lookups.scala.html
                  HASH: 943b40797f4149387dd8b703f2f545eef0f8674e
                  MATRIX: 771->1|899->34|929->39|947->49|986->51|1017->56|1057->70|1071->76|1131->116|1208->167|1222->173|1287->218|1363->268|1377->274|1428->305|1559->409|1587->410|1619->415|1722->490|1751->491|1784->497|1834->520|1862->521|1895->527|1923->528|2695->1273|2733->1295|2773->1297|2815->1312|2866->1354|2906->1356|2949->1372|2964->1378|2990->1383|3020->1386|3035->1392|3061->1397|3103->1407|3148->1421|3189->1434|3677->1896|3715->1918|3755->1920|3789->1927|3854->1965|3869->1971|3900->1981|3930->1984|3945->1990|3977->2001|4047->2044|4062->2050|4093->2060|4123->2063|4138->2069|4164->2074|4234->2117|4249->2123|4280->2133|4310->2136|4325->2142|4358->2154|4417->2183|4451->2190
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->9|40->9|41->10|42->11|42->11|43->12|44->13|44->13|45->14|45->14|63->32|63->32|63->32|64->33|64->33|64->33|64->33|64->33|64->33|64->33|64->33|64->33|64->33|65->34|66->35|86->55|86->55|86->55|87->56|88->57|88->57|88->57|88->57|88->57|88->57|89->58|89->58|89->58|89->58|89->58|89->58|90->59|90->59|90->59|90->59|90->59|90->59|92->61|93->62
                  -- GENERATED --
              */
          