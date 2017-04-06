
package views.html.reports

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object charts1_Scope0 {
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

class charts1 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

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
                     'width':500,
                     'height':400"""),format.raw/*24.34*/("""}"""),format.raw/*24.35*/(""";

				// Instantiate and draw the chart.
				var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));
				
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
object charts1 extends charts1_Scope0.charts1
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/reports/charts1.scala.html
                  HASH: a6c997f4acd07f6443bc40e907ce7e0bbf35da83
                  MATRIX: 764->1|894->36|924->41|942->51|981->53|1011->57|1305->324|1333->325|1365->331|1422->362|1449->363|1558->444|1587->445|1620->451|1666->470|1697->480|1752->508|1778->513|2061->768|2090->769|2208->859|2237->860|2436->1031|2465->1032|2505->1044|2607->1118|2636->1119|2679->1134|2815->1243|2843->1244|2876->1250|2904->1251|2941->1261|3084->1377|3112->1378|3143->1382
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|38->7|38->7|39->8|40->9|40->9|43->12|43->12|44->13|44->13|44->13|45->14|45->14|53->22|53->22|55->24|55->24|60->29|60->29|61->30|62->31|62->31|63->32|65->34|65->34|66->35|66->35|68->37|71->40|71->40|72->41
                  -- GENERATED --
              */
          