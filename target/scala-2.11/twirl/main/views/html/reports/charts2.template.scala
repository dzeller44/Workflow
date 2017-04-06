
package views.html.reports

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object charts2_Scope0 {
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

class charts2 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(jsonString1: String, jsonString2: String, title1: String, title2: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.76*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
		google.charts.load('current', """),format.raw/*7.33*/("""{"""),format.raw/*7.34*/("""
			"""),format.raw/*8.4*/("""packages : [ 'corechart' ]
		"""),format.raw/*9.3*/("""}"""),format.raw/*9.4*/(""");
		google.charts.setOnLoadCallback(drawChart1);
		google.charts.setOnLoadCallback(drawChart2);
		
		function drawChart1() """),format.raw/*13.25*/("""{"""),format.raw/*13.26*/("""
			"""),format.raw/*14.4*/("""var jsonString = """"),_display_(/*14.23*/jsonString1),format.raw/*14.34*/("""";
			var reportTitle = """"),_display_(/*15.24*/title1),format.raw/*15.30*/("""";
			var newJSON = jsonString.replace(/&#x27;/g, '"');
			console.log("newJSON1: " + newJSON);
			
			// Define the chart to be drawn.
			var data = new google.visualization.DataTable(newJSON);
			
			// Set chart options
			var options = """),format.raw/*23.18*/("""{"""),format.raw/*23.19*/("""'title':reportTitle,
		                  'width':500,
		                  'height':400"""),format.raw/*25.33*/("""}"""),format.raw/*25.34*/(""";
		
			// Instantiate and draw the chart.
			var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));
			chart.draw(data, options);
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/("""
		
		"""),format.raw/*32.3*/("""function drawChart2() """),format.raw/*32.25*/("""{"""),format.raw/*32.26*/("""
			"""),format.raw/*33.4*/("""var jsonString = """"),_display_(/*33.23*/jsonString2),format.raw/*33.34*/("""";
			var reportTitle = """"),_display_(/*34.24*/title2),format.raw/*34.30*/("""";
			var newJSON = jsonString.replace(/&#x27;/g, '"');
			console.log("newJSON2: " + newJSON);
			
			// Define the chart to be drawn.
			var data = new google.visualization.DataTable(newJSON);
			
			// Set chart options
			var options = """),format.raw/*42.18*/("""{"""),format.raw/*42.19*/("""'title':reportTitle,
		                  'width':500,
		                  'height':400"""),format.raw/*44.33*/("""}"""),format.raw/*44.34*/(""";
		
			// Instantiate and draw the chart.
			var chart = new google.visualization.BarChart(document.getElementById('myBarChart'));
			chart.draw(data, options);
		"""),format.raw/*49.3*/("""}"""),format.raw/*49.4*/("""
	"""),format.raw/*50.2*/("""</script>
	<section id="displayResults" style="padding: 30px;">
		<div class="container">
		<div class="row" style="padding-bottom: 16px">
			<div class="col-md-4">
				<div id="myPieChart"/>
				</div>
			</div>
			<div class="col-md-4">
				<div id="myBarChart"/>
				</div>
			</div>
		</div>
	</section>
""")))}))
      }
    }
  }

  def render(jsonString1:String,jsonString2:String,title1:String,title2:String): play.twirl.api.HtmlFormat.Appendable = apply(jsonString1,jsonString2,title1,title2)

  def f:((String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (jsonString1,jsonString2,title1,title2) => apply(jsonString1,jsonString2,title1,title2)

  def ref: this.type = this

}


}

/**/
object charts2 extends charts2_Scope0.charts2
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:51 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/reports/charts2.scala.html
                  HASH: a31ce502fc7e52570e55ba14139085691cedfa13
                  MATRIX: 778->1|947->75|977->80|995->90|1034->92|1063->95|1354->359|1382->360|1413->365|1469->395|1496->396|1652->524|1681->525|1713->530|1759->549|1791->560|1845->587|1872->593|2148->841|2177->842|2293->930|2322->931|2518->1100|2546->1101|2581->1109|2631->1131|2660->1132|2692->1137|2738->1156|2770->1167|2824->1194|2851->1200|3127->1448|3156->1449|3272->1537|3301->1538|3497->1707|3525->1708|3555->1711
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|38->7|38->7|39->8|40->9|40->9|44->13|44->13|45->14|45->14|45->14|46->15|46->15|54->23|54->23|56->25|56->25|61->30|61->30|63->32|63->32|63->32|64->33|64->33|64->33|65->34|65->34|73->42|73->42|75->44|75->44|80->49|80->49|81->50
                  -- GENERATED --
              */
          