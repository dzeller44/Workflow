
package views.html.workflow

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profileview_Scope0 {
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

class profileview extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[java.util.List[models.workflow.WorkflowProfile],java.util.List[models.workflow.WorkflowLookup],models.workflow.WorkflowUser,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(profileList: java.util.List[models.workflow.WorkflowProfile], lookups: java.util.List[models.workflow.WorkflowLookup], user: models.workflow.WorkflowUser):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.157*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("js/jquery/jquery-latest.js")),format.raw/*4.62*/("""" type="text/javascript"></script>
	<script src=""""),_display_(/*5.16*/routes/*5.22*/.Assets.at("js/jquery/jquery.tablesorter.js")),format.raw/*5.67*/("""" type="text/javascript"></script>
	<link href=""""),_display_(/*6.15*/routes/*6.21*/.Assets.at("css/tablesort.css")),format.raw/*6.52*/("""" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function() """),format.raw/*8.32*/("""{"""),format.raw/*8.33*/("""
			"""),format.raw/*9.4*/("""$("#tableAll").tablesorter();
			$(".selectFirstField").change(function() """),format.raw/*10.45*/("""{"""),format.raw/*10.46*/("""
				"""),format.raw/*11.5*/("""wkflwFilterProfileView("selectFirstField", "agency");
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""");
			$(".selectSecondField").change(function() """),format.raw/*13.46*/("""{"""),format.raw/*13.47*/("""
				"""),format.raw/*14.5*/("""wkflwFilterProfileView("selectSecondField", "position");
			"""),format.raw/*15.4*/("""}"""),format.raw/*15.5*/(""");
		"""),format.raw/*16.3*/("""}"""),format.raw/*16.4*/(""");
	</script>
	<section id="displayResults" style="padding: 30px;">
		<div class="table-responsive">
			<h5>All Cards:</h5>
			"""),_display_(/*21.5*/if(user.role.toString == "9")/*21.34*/ {_display_(Seq[Any](format.raw/*21.36*/("""
				"""),format.raw/*22.5*/("""<a href="/wkflwaddprofile" class="buttonCustomView" style="color: #FFFFFF;">Add New Profile</a>
  			""")))}),format.raw/*23.7*/("""
			"""),format.raw/*24.4*/("""<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="element-select">
							<div class="selectDropdownField">
								<div class="large">
									<span>
										<select class="selectFirstField" name="selectFirstField" id="selectFirstField">
											<option selected="selected" value="" disabled="disabled">--- Filter By Agency ---</option>
											<option value="All">All</option>
												"""),_display_(/*34.14*/for(lookup <- lookups) yield /*34.36*/ {_display_(Seq[Any](format.raw/*34.38*/("""
													"""),_display_(/*35.15*/if(lookup.getLookupType() == "Agency")/*35.53*/ {_display_(Seq[Any](format.raw/*35.55*/("""
														"""),format.raw/*36.15*/("""<option value=""""),_display_(/*36.31*/lookup/*36.37*/.getName()),format.raw/*36.47*/("""">"""),_display_(/*36.50*/lookup/*36.56*/.getName()),format.raw/*36.66*/("""</option>
													""")))}),format.raw/*37.15*/("""
												""")))}),format.raw/*38.14*/("""	
										"""),format.raw/*39.11*/("""</select>
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
						<th>Application Name</th>
						<th>Description</th>
						<th>Agency</th>
						<th>Owner</th>
					</tr>
				</thead>
				<tbody>
					"""),_display_(/*58.7*/for(profile <- profileList) yield /*58.34*/ {_display_(Seq[Any](format.raw/*58.36*/("""
					"""),format.raw/*59.6*/("""<tr>
						<td><a href="/wkflwopenprofile/"""),_display_(/*60.39*/profile/*60.46*/.getAppKey()),format.raw/*60.58*/("""">"""),_display_(/*60.61*/profile/*60.68*/.getAppName()),format.raw/*60.81*/("""</a></td>
						<td><a href="/wkflwopenprofile/"""),_display_(/*61.39*/profile/*61.46*/.getAppKey()),format.raw/*61.58*/("""">"""),_display_(/*61.61*/profile/*61.68*/.getAppDesc()),format.raw/*61.81*/("""</a></td>
						<td><a href="/wkflwopenprofile/"""),_display_(/*62.39*/profile/*62.46*/.getAppKey()),format.raw/*62.58*/("""">"""),_display_(/*62.61*/profile/*62.68*/.getAppAgency()),format.raw/*62.83*/("""</a></td>
						<td><a href="/wkflwopenprofile/"""),_display_(/*63.39*/profile/*63.46*/.getAppKey()),format.raw/*63.58*/("""">"""),_display_(/*63.61*/profile/*63.68*/.getAppOwner()),format.raw/*63.82*/("""</a></td>
					</tr>
					""")))}),format.raw/*65.7*/(""" 
				"""),format.raw/*66.5*/("""</tbody>
			</table>
		</div>
		<div><a href="/exportprofiles/All" class="buttonCustomView" style="color: #FFFFFF;">Export This View</a></div>
	</section>
""")))}))
      }
    }
  }

  def render(profileList:java.util.List[models.workflow.WorkflowProfile],lookups:java.util.List[models.workflow.WorkflowLookup],user:models.workflow.WorkflowUser): play.twirl.api.HtmlFormat.Appendable = apply(profileList,lookups,user)

  def f:((java.util.List[models.workflow.WorkflowProfile],java.util.List[models.workflow.WorkflowLookup],models.workflow.WorkflowUser) => play.twirl.api.HtmlFormat.Appendable) = (profileList,lookups,user) => apply(profileList,lookups,user)

  def ref: this.type = this

}


}

/**/
object profileview extends profileview_Scope0.profileview
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:51 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/workflow/profileview.scala.html
                  HASH: 7728e3ed1fb31bed1f06ad18cf03ffc6d2057504
                  MATRIX: 883->1|1134->156|1164->161|1182->171|1221->173|1250->176|1290->190|1304->196|1364->236|1441->287|1455->293|1520->338|1596->388|1610->394|1661->425|1792->529|1820->530|1851->535|1954->610|1983->611|2016->617|2101->675|2129->676|2206->725|2235->726|2268->732|2356->793|2384->794|2417->800|2445->801|2604->934|2642->963|2682->965|2715->971|2848->1074|2880->1079|3360->1532|3398->1554|3438->1556|3481->1572|3528->1610|3568->1612|3612->1628|3655->1644|3670->1650|3701->1660|3731->1663|3746->1669|3777->1679|3833->1704|3879->1719|3920->1732|4374->2160|4417->2187|4457->2189|4491->2196|4562->2240|4578->2247|4611->2259|4641->2262|4657->2269|4691->2282|4767->2331|4783->2338|4816->2350|4846->2353|4862->2360|4896->2373|4972->2422|4988->2429|5021->2441|5051->2444|5067->2451|5103->2466|5179->2515|5195->2522|5228->2534|5258->2537|5274->2544|5309->2558|5368->2587|5402->2594
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|35->4|35->4|35->4|36->5|36->5|36->5|37->6|37->6|37->6|39->8|39->8|40->9|41->10|41->10|42->11|43->12|43->12|44->13|44->13|45->14|46->15|46->15|47->16|47->16|52->21|52->21|52->21|53->22|54->23|55->24|65->34|65->34|65->34|66->35|66->35|66->35|67->36|67->36|67->36|67->36|67->36|67->36|67->36|68->37|69->38|70->39|89->58|89->58|89->58|90->59|91->60|91->60|91->60|91->60|91->60|91->60|92->61|92->61|92->61|92->61|92->61|92->61|93->62|93->62|93->62|93->62|93->62|93->62|94->63|94->63|94->63|94->63|94->63|94->63|96->65|97->66
                  -- GENERATED --
              */
          