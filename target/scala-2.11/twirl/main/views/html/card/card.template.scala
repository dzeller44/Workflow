
package views.html.card

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object card_Scope0 {
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

class card extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[Application.CardAdd],java.util.List[Team],java.util.List[Lookup],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(rookieCard: Form[Application.CardAdd], teams: java.util.List[Team], lookups: java.util.List[Lookup]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.103*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*5.31*/("""{"""),format.raw/*5.32*/("""		 
			"""),format.raw/*6.4*/("""$('input[name=selectServices]').on('change', function() """),format.raw/*6.60*/("""{"""),format.raw/*6.61*/("""
				"""),format.raw/*7.5*/("""$('#services').val($('input[name=selectServices]:checked').map(function() """),format.raw/*7.79*/("""{"""),format.raw/*7.80*/("""
					"""),format.raw/*8.6*/("""return this.value;
				"""),format.raw/*9.5*/("""}"""),format.raw/*9.6*/(""").get());
			"""),format.raw/*10.4*/("""}"""),format.raw/*10.5*/(""");
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""");
	</script>
	<section id="rookieCard">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS','Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Rookie Card</h2>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Player Name:</label>
				<div class="item-cont"><input class="large" type="text" name="name" required="required" placeholder="Enter the Player's Name..."/><span class="icon-place"></span></div>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Position:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="position" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Position ---</option>
								"""),_display_(/*31.10*/for(lookup <- lookups) yield /*31.32*/ {_display_(Seq[Any](format.raw/*31.34*/("""
									"""),_display_(/*32.11*/if(lookup.lookuptype == "Position")/*32.46*/ {_display_(Seq[Any](format.raw/*32.48*/("""
										"""),format.raw/*33.11*/("""<option value=""""),_display_(/*33.27*/lookup/*33.33*/.name),format.raw/*33.38*/("""">"""),_display_(/*33.41*/lookup/*33.47*/.name),format.raw/*33.52*/("""</option>
									""")))}),format.raw/*34.11*/("""
								""")))}),format.raw/*35.10*/("""	
							"""),format.raw/*36.8*/("""</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Team:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="team" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Team ---</option>
								"""),_display_(/*49.10*/for(team <- teams) yield /*49.28*/ {_display_(Seq[Any](format.raw/*49.30*/("""
									"""),format.raw/*50.10*/("""<option value=""""),_display_(/*50.26*/team/*50.30*/.name),format.raw/*50.35*/("""">"""),_display_(/*50.38*/team/*50.42*/.name),format.raw/*50.47*/("""</option>
								""")))}),format.raw/*51.10*/("""
							"""),format.raw/*52.8*/("""</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<div class="element-radio">
				<label class="title">Select the Card Maker...<span class="required">*</span>Card Maker:</label>
				"""),_display_(/*60.6*/for(lookup <- lookups) yield /*60.28*/ {_display_(Seq[Any](format.raw/*60.30*/("""
					"""),_display_(/*61.7*/if(lookup.lookuptype == "Card Maker")/*61.44*/ {_display_(Seq[Any](format.raw/*61.46*/("""
						"""),format.raw/*62.7*/("""<input type="radio" name="cardmaker" value=""""),_display_(/*62.52*/lookup/*62.58*/.name),format.raw/*62.63*/("""" required="required"/><span>"""),_display_(/*62.93*/lookup/*62.99*/.name),format.raw/*62.104*/("""</span></label>
						<span class="clearfix"></span>
					""")))}),format.raw/*64.7*/("""
				""")))}),format.raw/*65.6*/("""
			"""),format.raw/*66.4*/("""</div>
			<div class="element-number">
				<label class="title"><span class="required">*</span>Card Year:</label>
				<div class="item-cont"><input class="large" type="text" min="0" max="5000" name="year" required="required" placeholder="Enter the Card Year..." value=""/><span class="icon-place"></span></div>
			</div>
			<div class="element-input">
				"""),_display_(/*72.6*/if(rookieCard.hasGlobalErrors)/*72.36*/ {_display_(Seq[Any](format.raw/*72.38*/("""
					"""),format.raw/*73.6*/("""<span class="errorMessageDisplay" style="color: #d9534f;">"""),_display_(/*73.65*/rookieCard/*73.75*/.globalError.message),format.raw/*73.95*/("""</span>
				""")))}),format.raw/*74.6*/("""
			"""),format.raw/*75.4*/("""</div>
			<div class="submit">
				<input type="submit" value="Submit" />
				<a href="/" class="buttonCancel">"""),_display_(/*78.39*/Messages("goback")),format.raw/*78.57*/("""</a>
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}))
      }
    }
  }

  def render(rookieCard:Form[Application.CardAdd],teams:java.util.List[Team],lookups:java.util.List[Lookup]): play.twirl.api.HtmlFormat.Appendable = apply(rookieCard,teams,lookups)

  def f:((Form[Application.CardAdd],java.util.List[Team],java.util.List[Lookup]) => play.twirl.api.HtmlFormat.Appendable) = (rookieCard,teams,lookups) => apply(rookieCard,teams,lookups)

  def ref: this.type = this

}


}

/**/
object card extends card_Scope0.card
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/card/card.scala.html
                  HASH: 130810cd538d76534af38e0976009dd968ce5311
                  MATRIX: 811->1|1008->102|1038->107|1056->117|1095->119|1124->122|1214->185|1242->186|1276->194|1359->250|1387->251|1419->257|1520->331|1548->332|1581->339|1631->363|1658->364|1699->378|1727->379|1760->385|1788->386|2793->1364|2831->1386|2871->1388|2910->1400|2954->1435|2994->1437|3034->1449|3077->1465|3092->1471|3118->1476|3148->1479|3163->1485|3189->1490|3241->1511|3283->1522|3320->1532|3783->1968|3817->1986|3857->1988|3896->1999|3939->2015|3952->2019|3978->2024|4008->2027|4021->2031|4047->2036|4098->2056|4134->2065|4408->2313|4446->2335|4486->2337|4520->2345|4566->2382|4606->2384|4641->2392|4713->2437|4728->2443|4754->2448|4811->2478|4826->2484|4853->2489|4944->2550|4981->2557|5013->2562|5402->2925|5441->2955|5481->2957|5515->2964|5601->3023|5620->3033|5661->3053|5705->3067|5737->3072|5879->3187|5918->3205
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|39->8|40->9|40->9|41->10|41->10|42->11|42->11|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|64->33|64->33|64->33|64->33|65->34|66->35|67->36|80->49|80->49|80->49|81->50|81->50|81->50|81->50|81->50|81->50|81->50|82->51|83->52|91->60|91->60|91->60|92->61|92->61|92->61|93->62|93->62|93->62|93->62|93->62|93->62|93->62|95->64|96->65|97->66|103->72|103->72|103->72|104->73|104->73|104->73|104->73|105->74|106->75|109->78|109->78
                  -- GENERATED --
              */
          