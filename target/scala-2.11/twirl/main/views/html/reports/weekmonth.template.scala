
package views.html.reports

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object weekmonth_Scope0 {
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

class weekmonth extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

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
			
			function selectHandler() """),format.raw/*30.29*/("""{"""),format.raw/*30.30*/("""
		        """),format.raw/*31.11*/("""var selectedItem = chart.getSelection()[0];
		        if (selectedItem) """),format.raw/*32.29*/("""{"""),format.raw/*32.30*/("""
		          """),format.raw/*33.13*/("""var topping = data.getValue(selectedItem.row, 0);
		          alert('The user selected ' + topping);
				"""),format.raw/*35.5*/("""}"""),format.raw/*35.6*/("""
			"""),format.raw/*36.4*/("""}"""),format.raw/*36.5*/("""
		
			"""),format.raw/*38.4*/("""google.visualization.events.addListener(chart, 'select', selectHandler);			
			
			chart.draw(data, options);
		"""),format.raw/*41.3*/("""}"""),format.raw/*41.4*/("""
		
		"""),format.raw/*43.3*/("""function drawChart2() """),format.raw/*43.25*/("""{"""),format.raw/*43.26*/("""
			"""),format.raw/*44.4*/("""var jsonString = """"),_display_(/*44.23*/jsonString2),format.raw/*44.34*/("""";
			var reportTitle = """"),_display_(/*45.24*/title2),format.raw/*45.30*/("""";
			var newJSON = jsonString.replace(/&#x27;/g, '"');
			console.log("newJSON2: " + newJSON);
			
			// Define the chart to be drawn.
			var data = new google.visualization.DataTable(newJSON);
			
			// Set chart options
			var options = """),format.raw/*53.18*/("""{"""),format.raw/*53.19*/("""'title':reportTitle,
		                  'width':500,
		                  'height':400"""),format.raw/*55.33*/("""}"""),format.raw/*55.34*/(""";
		
			// Instantiate and draw the chart.
			var chart = new google.visualization.BarChart(document.getElementById('myBarChart'));
			chart.draw(data, options);
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/("""
	"""),format.raw/*61.2*/("""</script>
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
object weekmonth extends weekmonth_Scope0.weekmonth
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:51 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/reports/weekmonth.scala.html
                  HASH: 8fa334b75c1d71d37b628d64f3a36406e2487a52
                  MATRIX: 782->1|951->75|981->80|999->90|1038->92|1067->95|1358->359|1386->360|1417->365|1473->395|1500->396|1656->524|1685->525|1717->530|1763->549|1795->560|1849->587|1876->593|2152->841|2181->842|2297->930|2326->931|2523->1100|2552->1101|2592->1113|2693->1186|2722->1187|2764->1201|2898->1308|2926->1309|2958->1314|2986->1315|3022->1324|3164->1439|3192->1440|3227->1448|3277->1470|3306->1471|3338->1476|3384->1495|3416->1506|3470->1533|3497->1539|3773->1787|3802->1788|3918->1876|3947->1877|4143->2046|4171->2047|4201->2050
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|38->7|38->7|39->8|40->9|40->9|44->13|44->13|45->14|45->14|45->14|46->15|46->15|54->23|54->23|56->25|56->25|61->30|61->30|62->31|63->32|63->32|64->33|66->35|66->35|67->36|67->36|69->38|72->41|72->41|74->43|74->43|74->43|75->44|75->44|75->44|76->45|76->45|84->53|84->53|86->55|86->55|91->60|91->60|92->61
                  -- GENERATED --
              */
          