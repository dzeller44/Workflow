
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object searchusers_Scope0 {
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

class searchusers extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[java.util.List[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userList: java.util.List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.34*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

	"""),format.raw/*5.2*/("""<script src=""""),_display_(/*5.16*/routes/*5.22*/.Assets.at("js/jquery/jquery-latest.js")),format.raw/*5.62*/("""" type="text/javascript"></script>
	<script src=""""),_display_(/*6.16*/routes/*6.22*/.Assets.at("js/jquery/jquery.tablesorter.js")),format.raw/*6.67*/("""" type="text/javascript"></script>
	<link href=""""),_display_(/*7.15*/routes/*7.21*/.Assets.at("css/tablesort.css")),format.raw/*7.52*/("""" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(document).ready(function() """),format.raw/*9.32*/("""{"""),format.raw/*9.33*/("""
			"""),format.raw/*10.4*/("""$("#tableAll").tablesorter();
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""");
	</script>
	<section id="displayResults" style="padding: 30px;">	
		<div class="table-responsive">
			<h5>All Users:</h5>
			<table id="tableAll" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
				<thead>
					<tr>
						<th>User Name</th>
						<th>Email</th>
						<th>Role</th>
					</tr>
				</thead>
				<tbody>
					"""),_display_(/*25.7*/for(user <- userList) yield /*25.28*/ {_display_(Seq[Any](format.raw/*25.30*/("""
					"""),format.raw/*26.6*/("""<tr>
						<td><a href="/finduserurl?userkey="""),_display_(/*27.42*/user/*27.46*/.getUserkey()),format.raw/*27.59*/("""">"""),_display_(/*27.62*/user/*27.66*/.fullname),format.raw/*27.75*/("""</a></td>
						<td><a href="/finduserurl?userkey="""),_display_(/*28.42*/user/*28.46*/.getUserkey()),format.raw/*28.59*/("""">"""),_display_(/*28.62*/user/*28.66*/.getEmail()),format.raw/*28.77*/("""</a></td>
						<td><a href="/finduserurl?userkey="""),_display_(/*29.42*/user/*29.46*/.getUserkey()),format.raw/*29.59*/("""">"""),_display_(/*29.62*/user/*29.66*/.getRoleProperName(user.role).capitalize),format.raw/*29.106*/("""</a></td>
					</tr>
					""")))}),format.raw/*31.7*/(""" 
				"""),format.raw/*32.5*/("""</tbody>
			</table>
		</div>
		<div><a href="/exportusers/All" class="buttonCustomView" style="color: #FFFFFF;">Export This View</a></div>
	</section>
""")))}))
      }
    }
  }

  def render(userList:java.util.List[User]): play.twirl.api.HtmlFormat.Appendable = apply(userList)

  def f:((java.util.List[User]) => play.twirl.api.HtmlFormat.Appendable) = (userList) => apply(userList)

  def ref: this.type = this

}


}

/**/
object searchusers extends searchusers_Scope0.searchusers
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/searchusers.scala.html
                  HASH: d584d38425ba84dcb1e413fbc3532752f8ae0715
                  MATRIX: 777->1|904->33|934->38|952->48|991->50|1022->55|1062->69|1076->75|1136->115|1213->166|1227->172|1292->217|1368->267|1382->273|1433->304|1564->408|1592->409|1624->414|1684->447|1712->448|2095->805|2132->826|2172->828|2206->835|2280->882|2293->886|2327->899|2357->902|2370->906|2400->915|2479->967|2492->971|2526->984|2556->987|2569->991|2601->1002|2680->1054|2693->1058|2727->1071|2757->1074|2770->1078|2832->1118|2891->1147|2925->1154
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->9|40->9|41->10|42->11|42->11|56->25|56->25|56->25|57->26|58->27|58->27|58->27|58->27|58->27|58->27|59->28|59->28|59->28|59->28|59->28|59->28|60->29|60->29|60->29|60->29|60->29|60->29|62->31|63->32
                  -- GENERATED --
              */
          