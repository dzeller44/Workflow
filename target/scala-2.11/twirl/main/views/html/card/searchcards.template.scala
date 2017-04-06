
package views.html.card

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object searchcards_Scope0 {
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

class searchcards extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[java.util.List[Card],java.util.List[Lookup],java.util.List[Team],User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(cardList: java.util.List[Card], lookups: java.util.List[Lookup], teams: java.util.List[Team], user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.108*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("js/jquery/jquery-latest.js")),format.raw/*4.62*/("""" type="text/javascript"></script>
	<script src=""""),_display_(/*5.16*/routes/*5.22*/.Assets.at("js/jquery/jquery.tablesorter.js")),format.raw/*5.67*/("""" type="text/javascript"></script>
	<link href=""""),_display_(/*6.15*/routes/*6.21*/.Assets.at("css/tablesort.css")),format.raw/*6.52*/("""" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function() """),format.raw/*8.32*/("""{"""),format.raw/*8.33*/("""
			"""),format.raw/*9.4*/("""$("#tableAll").tablesorter();
			$(".selectFirstField").change(function() """),format.raw/*10.45*/("""{"""),format.raw/*10.46*/("""
				"""),format.raw/*11.5*/("""filterCardSearch("selectFirstField", "team");
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""");
			$(".selectSecondField").change(function() """),format.raw/*13.46*/("""{"""),format.raw/*13.47*/("""
				"""),format.raw/*14.5*/("""filterCardSearch("selectSecondField", "position");
			"""),format.raw/*15.4*/("""}"""),format.raw/*15.5*/(""");
		"""),format.raw/*16.3*/("""}"""),format.raw/*16.4*/(""");
	</script>
	<section id="displayResults" style="padding: 30px;">
		<div class="table-responsive">
			<h5>All Cards:</h5>
			"""),_display_(/*21.5*/if(user.role.toString == "2")/*21.34*/ {_display_(Seq[Any](format.raw/*21.36*/("""
				"""),format.raw/*22.5*/("""<a href="/addcard" class="buttonCustomView" style="color: #FFFFFF;">Add New Card</a>
  			""")))}),format.raw/*23.7*/("""
			"""),format.raw/*24.4*/("""<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="element-select">
							<div class="selectDropdownField">
								<div class="large">
									<span>
										<select class="selectFirstField" name="selectFirstField" id="selectFirstField">
											<option selected="selected" value="" disabled="disabled">--- Filter By Team ---</option>
											<option value="All">All</option>
											"""),_display_(/*34.13*/for(team <- teams) yield /*34.31*/ {_display_(Seq[Any](format.raw/*34.33*/("""
												"""),format.raw/*35.13*/("""<option value=""""),_display_(/*35.29*/team/*35.33*/.name),format.raw/*35.38*/("""">"""),_display_(/*35.41*/team/*35.45*/.name),format.raw/*35.50*/("""</option>
											""")))}),format.raw/*36.13*/("""	
										"""),format.raw/*37.11*/("""</select>
										<i></i><span class="iconPlacement"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="element-select">
							<div class="selectDropdownField">
								<div class="large">
									<span>
										<select class="selectSecondField" name="selectSecondField" id="selectSecondField">
											<option selected="selected" value="" disabled="disabled">--- Filter By Position ---</option>
											<option value="All">All</option>
											"""),_display_(/*52.13*/for(lookup <- lookups) yield /*52.35*/ {_display_(Seq[Any](format.raw/*52.37*/("""
												"""),_display_(/*53.14*/if(lookup.lookuptype == "Position")/*53.49*/ {_display_(Seq[Any](format.raw/*53.51*/("""<option value=""""),_display_(/*53.67*/lookup/*53.73*/.name),format.raw/*53.78*/("""">"""),_display_(/*53.81*/lookup/*53.87*/.name),format.raw/*53.92*/("""</option>""")))}),format.raw/*53.102*/("""
											""")))}),format.raw/*54.13*/("""	
										"""),format.raw/*55.11*/("""</select>
										<i></i><span class="iconPlacement"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<table id="tableAll" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
				<thead>
					<tr>
						<th>Player Name</th>
						<th>Team</th>
						<th>Position</th>
						<th>Year</th>
						<th>Card Maker</th>
					</tr>
				</thead>
				<tbody>
					"""),_display_(/*75.7*/for(card <- cardList) yield /*75.28*/ {_display_(Seq[Any](format.raw/*75.30*/("""
					"""),format.raw/*76.6*/("""<tr>
						<td><a href="/opencard/"""),_display_(/*77.31*/card/*77.35*/.uniquekey),format.raw/*77.45*/("""">"""),_display_(/*77.48*/card/*77.52*/.name),format.raw/*77.57*/("""</a></td>
						<td><a href="/opencard/"""),_display_(/*78.31*/card/*78.35*/.uniquekey),format.raw/*78.45*/("""">"""),_display_(/*78.48*/card/*78.52*/.team),format.raw/*78.57*/("""</a></td>
						<td><a href="/opencard/"""),_display_(/*79.31*/card/*79.35*/.uniquekey),format.raw/*79.45*/("""">"""),_display_(/*79.48*/card/*79.52*/.position),format.raw/*79.61*/("""</a></td>
						<td><a href="/opencard/"""),_display_(/*80.31*/card/*80.35*/.uniquekey),format.raw/*80.45*/("""">"""),_display_(/*80.48*/card/*80.52*/.year),format.raw/*80.57*/("""</a></td>
						<td><a href="/opencard/"""),_display_(/*81.31*/card/*81.35*/.uniquekey),format.raw/*81.45*/("""">"""),_display_(/*81.48*/card/*81.52*/.cardmaker),format.raw/*81.62*/("""</a></td>
					</tr>
					""")))}),format.raw/*83.7*/(""" 
				"""),format.raw/*84.5*/("""</tbody>
			</table>
		</div>
		<div><a href="/exportprofiles/All" class="buttonCustomView" style="color: #FFFFFF;">Export This View</a></div>
	</section>
""")))}))
      }
    }
  }

  def render(cardList:java.util.List[Card],lookups:java.util.List[Lookup],teams:java.util.List[Team],user:User): play.twirl.api.HtmlFormat.Appendable = apply(cardList,lookups,teams,user)

  def f:((java.util.List[Card],java.util.List[Lookup],java.util.List[Team],User) => play.twirl.api.HtmlFormat.Appendable) = (cardList,lookups,teams,user) => apply(cardList,lookups,teams,user)

  def ref: this.type = this

}


}

/**/
object searchcards extends searchcards_Scope0.searchcards
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/card/searchcards.scala.html
                  HASH: 90e03ef83a2abfc21a1083b423aaea1b244e2f5d
                  MATRIX: 825->1|1027->107|1057->112|1075->122|1114->124|1143->127|1183->141|1197->147|1257->187|1334->238|1348->244|1413->289|1489->339|1503->345|1554->376|1685->480|1713->481|1744->486|1847->561|1876->562|1909->568|1986->618|2014->619|2091->668|2120->669|2153->675|2235->730|2263->731|2296->737|2324->738|2483->871|2521->900|2561->902|2594->908|2716->1000|2748->1005|3225->1455|3259->1473|3299->1475|3341->1489|3384->1505|3397->1509|3423->1514|3453->1517|3466->1521|3492->1526|3546->1549|3587->1562|4164->2112|4202->2134|4242->2136|4284->2151|4328->2186|4368->2188|4411->2204|4426->2210|4452->2215|4482->2218|4497->2224|4523->2229|4565->2239|4610->2253|4651->2266|5121->2710|5158->2731|5198->2733|5232->2740|5295->2776|5308->2780|5339->2790|5369->2793|5382->2797|5408->2802|5476->2843|5489->2847|5520->2857|5550->2860|5563->2864|5589->2869|5657->2910|5670->2914|5701->2924|5731->2927|5744->2931|5774->2940|5842->2981|5855->2985|5886->2995|5916->2998|5929->3002|5955->3007|6023->3048|6036->3052|6067->3062|6097->3065|6110->3069|6141->3079|6200->3108|6234->3115
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|35->4|35->4|35->4|36->5|36->5|36->5|37->6|37->6|37->6|39->8|39->8|40->9|41->10|41->10|42->11|43->12|43->12|44->13|44->13|45->14|46->15|46->15|47->16|47->16|52->21|52->21|52->21|53->22|54->23|55->24|65->34|65->34|65->34|66->35|66->35|66->35|66->35|66->35|66->35|66->35|67->36|68->37|83->52|83->52|83->52|84->53|84->53|84->53|84->53|84->53|84->53|84->53|84->53|84->53|84->53|85->54|86->55|106->75|106->75|106->75|107->76|108->77|108->77|108->77|108->77|108->77|108->77|109->78|109->78|109->78|109->78|109->78|109->78|110->79|110->79|110->79|110->79|110->79|110->79|111->80|111->80|111->80|111->80|111->80|111->80|112->81|112->81|112->81|112->81|112->81|112->81|114->83|115->84
                  -- GENERATED --
              */
          