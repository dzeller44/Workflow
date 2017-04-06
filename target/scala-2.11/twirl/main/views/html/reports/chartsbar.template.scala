
package views.html.reports

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object chartsbar_Scope0 {
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

class chartsbar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(jsonString: String, title: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
  """),format.raw/*4.3*/("""<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script type="text/javascript">
			google.charts.load('current', """),format.raw/*7.34*/("""{"""),format.raw/*7.35*/("""
				"""),format.raw/*8.5*/("""packages : [ 'corechart' ]
			"""),format.raw/*9.4*/("""}"""),format.raw/*9.5*/(""");
			google.charts.setOnLoadCallback(drawChart);
			
			function drawChart() """),format.raw/*12.25*/("""{"""),format.raw/*12.26*/("""
				"""),format.raw/*13.5*/("""var jsonString = """"),_display_(/*13.24*/jsonString),format.raw/*13.34*/("""";
				var reportTitle = """"),_display_(/*14.25*/title),format.raw/*14.30*/("""";
				var newJSON = jsonString.replace(/&#x27;/g, '"');
				console.log("newJSON: " + newJSON);
				
				// Define the chart to be drawn.
				var data = new google.visualization.DataTable(newJSON);
				
				// Set chart options
				var options = """),format.raw/*22.19*/("""{"""),format.raw/*22.20*/("""'title':reportTitle,
                     'width':1200,
                     'height':2400"""),format.raw/*24.35*/("""}"""),format.raw/*24.36*/(""";

				// Instantiate and draw the chart.
				var chart = new google.visualization.BarChart(document.getElementById('myPieChart'));
				
				function selectHandler() """),format.raw/*29.30*/("""{"""),format.raw/*29.31*/("""
		        """),format.raw/*30.11*/("""var selectedItem = chart.getSelection()[0];
			        if (selectedItem) """),format.raw/*31.30*/("""{"""),format.raw/*31.31*/("""
			          """),format.raw/*32.14*/("""var topping = data.getValue(selectedItem.row, 0);
			          alert('The user selected ' + topping);
					"""),format.raw/*34.6*/("""}"""),format.raw/*34.7*/("""
				"""),format.raw/*35.5*/("""}"""),format.raw/*35.6*/("""
		
				"""),format.raw/*37.5*/("""google.visualization.events.addListener(chart, 'select', selectHandler);	
				
				chart.draw(data, options);
			"""),format.raw/*40.4*/("""}"""),format.raw/*40.5*/("""
		"""),format.raw/*41.3*/("""</script>
	<section id="displayResults" style="padding: 30px;">
	<div class="container">
			<div class="row" style="padding-bottom: 16px">
				<div class="col-md-4">
				<div id="myPieChart"/>
				</div>
				</div>
				</div>	
	</section>
""")))}))
      }
    }
  }

  def render(jsonString:String,title:String): play.twirl.api.HtmlFormat.Appendable = apply(jsonString,title)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (jsonString,title) => apply(jsonString,title)

  def ref: this.type = this

}


}

/**/
object chartsbar extends chartsbar_Scope0.chartsbar
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:51 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/reports/chartsbar.scala.html
                  HASH: 1a1cda8758dd05e310878df8b96b9868fb452c07
                  MATRIX: 768->1|898->36|928->41|946->51|985->53|1015->57|1309->324|1337->325|1369->331|1426->362|1453->363|1562->444|1591->445|1624->451|1670->470|1701->480|1756->508|1782->513|2065->768|2094->769|2214->861|2243->862|2442->1033|2471->1034|2511->1046|2613->1120|2642->1121|2685->1136|2821->1245|2849->1246|2882->1252|2910->1253|2947->1263|3090->1379|3118->1380|3149->1384
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|38->7|38->7|39->8|40->9|40->9|43->12|43->12|44->13|44->13|44->13|45->14|45->14|53->22|53->22|55->24|55->24|60->29|60->29|61->30|62->31|62->31|63->32|65->34|65->34|66->35|66->35|68->37|71->40|71->40|72->41
                  -- GENERATED --
              */
          