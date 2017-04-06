
package views.html.card

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object editcard_Scope0 {
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

class editcard extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[Form[Application.CardAdd],Card,java.util.List[Team],java.util.List[Lookup],java.util.List[CardAudit],java.util.List[Comment],User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(rookieCard: Form[Application.CardAdd], card: Card, teams: java.util.List[Team], lookups: java.util.List[Lookup], auditTrail: java.util.List[CardAudit], allComments: java.util.List[Comment], user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import java.text.SimpleDateFormat

Seq[Any](format.raw/*1.204*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(null)/*5.12*/ {_display_(Seq[Any](format.raw/*5.14*/("""
	"""),format.raw/*6.2*/("""<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*7.31*/("""{"""),format.raw/*7.32*/("""		 
			"""),format.raw/*8.4*/("""$('input[name=selectServices]').on('change', function() """),format.raw/*8.60*/("""{"""),format.raw/*8.61*/("""
				"""),format.raw/*9.5*/("""$('#services').val($('input[name=selectServices]:checked').map(function() """),format.raw/*9.79*/("""{"""),format.raw/*9.80*/("""
					"""),format.raw/*10.6*/("""return this.value;
				"""),format.raw/*11.5*/("""}"""),format.raw/*11.6*/(""").get());
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/(""");
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/(""");
	</script>
	<input type="hidden" name="uniquekey" id="uniquekey" value=""""),_display_(/*15.63*/card/*15.67*/.uniquekey),format.raw/*15.77*/("""" />
	<section id="rookieCard">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS','Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Rookie Card</h2>
			</div>
			<div class="formSubtitle">
				Player Info
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Player Name:</label>
				<div class="item-cont"><input class="large" type="text" name="name" required="required" placeholder="Enter the Player's Name..." value=""""),_display_(/*28.142*/card/*28.146*/.name),format.raw/*28.151*/("""" /><span class="icon-place"></span></div>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Position:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="position" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Position ---</option>
								"""),_display_(/*37.10*/for(lookup <- lookups) yield /*37.32*/ {_display_(Seq[Any](format.raw/*37.34*/("""
									"""),_display_(/*38.11*/if(lookup.lookuptype == "Position")/*38.46*/ {_display_(Seq[Any](format.raw/*38.48*/("""<option """),_display_(/*38.57*/if(lookup.name == card.position)/*38.89*/ {_display_(Seq[Any](format.raw/*38.91*/("""selected="selected"""")))}),format.raw/*38.111*/(""" """),format.raw/*38.112*/("""value=""""),_display_(/*38.120*/lookup/*38.126*/.name),format.raw/*38.131*/("""">"""),_display_(/*38.134*/lookup/*38.140*/.name),format.raw/*38.145*/("""</option>""")))}),format.raw/*38.155*/("""
								""")))}),format.raw/*39.10*/("""	
							"""),format.raw/*40.8*/("""</select>
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
								"""),_display_(/*53.10*/for(team <- teams) yield /*53.28*/ {_display_(Seq[Any](format.raw/*53.30*/("""
									"""),format.raw/*54.10*/("""{"""),format.raw/*54.11*/("""<option """),_display_(/*54.20*/if(team.name == card.team)/*54.46*/ {_display_(Seq[Any](format.raw/*54.48*/("""selected="selected"""")))}),format.raw/*54.68*/(""" """),format.raw/*54.69*/("""value=""""),_display_(/*54.77*/team/*54.81*/.name),format.raw/*54.86*/("""">"""),_display_(/*54.89*/team/*54.93*/.name),format.raw/*54.98*/("""</option>"""),format.raw/*54.107*/("""}"""),format.raw/*54.108*/("""
								""")))}),format.raw/*55.10*/("""
							"""),format.raw/*56.8*/("""</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<div class="element-radio">
				<label class="title"><span class="required">*</span>Card Maker:</label>
				"""),_display_(/*64.6*/for(lookup <- lookups) yield /*64.28*/ {_display_(Seq[Any](format.raw/*64.30*/("""
					"""),_display_(/*65.7*/if(lookup.lookuptype == "Card Maker")/*65.44*/ {_display_(Seq[Any](format.raw/*65.46*/("""
						"""),format.raw/*66.7*/("""<input type="radio" name="cardmaker" value=""""),_display_(/*66.52*/lookup/*66.58*/.name),format.raw/*66.63*/("""" required="required" """),_display_(/*66.86*/if(lookup.name == card.cardmaker)/*66.119*/ {_display_(Seq[Any](format.raw/*66.121*/("""checked""")))}),format.raw/*66.129*/(""" """),format.raw/*66.130*/("""/><span>"""),_display_(/*66.139*/lookup/*66.145*/.name),format.raw/*66.150*/("""</span></label>
						<span class="clearfix"></span>
					""")))}),format.raw/*68.7*/("""
				""")))}),format.raw/*69.6*/("""
			"""),format.raw/*70.4*/("""</div>
			<div class="element-number">
				<label class="title"><span class="required">*</span>Card Year:</label>
				<div class="item-cont"><input class="large" type="text" min="0" max="5000" name="year" required="required" placeholder="Enter the Card Year..."  value=""""),_display_(/*73.158*/card/*73.162*/.year),format.raw/*73.167*/("""" /><span class="icon-place"></span></div>
			</div>
			<div class="formSubtitle">
				Comments
			</div>
			<div class="element-input">
				<span class="text-center"><button type="button" class="buttonCustomView" align="center" style="color: #FFFFFF;" data-toggle="modal" data-target="#modalComments">Add Comments</button></span>
				<br><br>
				"""),_display_(/*81.6*/if(!allComments.isEmpty)/*81.30*/ {_display_(Seq[Any](format.raw/*81.32*/("""
					"""),format.raw/*82.6*/("""<div class="modifiedSection" style="font-size: 12px;">
						<table class="modifiedTable">
							"""),_display_(/*84.9*/for(comment <- allComments) yield /*84.36*/ {_display_(Seq[Any](format.raw/*84.38*/("""
								"""),format.raw/*85.9*/("""<tr>
									<td width="25%">"""),_display_(/*86.27*/if(comment.datecreated != null)/*86.58*/{_display_(_display_(/*86.60*/(new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(comment.datecreated))))}),format.raw/*86.133*/("""</td>
									<td width="25%">"""),_display_(/*87.27*/comment/*87.34*/.author),format.raw/*87.41*/("""</td>
									<td width="50%">"""),_display_(/*88.27*/comment/*88.34*/.comment),format.raw/*88.42*/("""</td>
								</tr>
							""")))}),format.raw/*90.9*/("""					
						"""),format.raw/*91.7*/("""</table>
					</div>
				""")))}),format.raw/*93.6*/("""
			"""),format.raw/*94.4*/("""</div>
			<div class="element-input">
				"""),_display_(/*96.6*/if(rookieCard.hasGlobalErrors)/*96.36*/ {_display_(Seq[Any](format.raw/*96.38*/("""
					"""),format.raw/*97.6*/("""<span class="errorMessageDisplay" style="color: #d9534f;">"""),_display_(/*97.65*/rookieCard/*97.75*/.globalError.message),format.raw/*97.95*/("""</span>
				""")))}),format.raw/*98.6*/("""
			"""),format.raw/*99.4*/("""</div>
			<div class="submit">
				<input type="submit" value="Submit" />
				<a href="/" class="buttonCancel">"""),_display_(/*102.39*/Messages("goback")),format.raw/*102.57*/("""</a>
			</div>
			"""),_display_(/*104.5*/if(user.role.toString() == "2")/*104.36*/ {_display_(Seq[Any](format.raw/*104.38*/("""
				"""),format.raw/*105.5*/("""<div class="submit">
					<a href="javascript:deleteCard('"""),_display_(/*106.39*/card/*106.43*/.uniquekey),format.raw/*106.53*/("""')" class="buttonDelete" style="color: #FFFFFF;">Delete</a>
				</div>
			""")))}),format.raw/*108.5*/("""
			"""),_display_(/*109.5*/if(!auditTrail.isEmpty)/*109.28*/ {_display_(Seq[Any](format.raw/*109.30*/("""
				"""),format.raw/*110.5*/("""<div class="modifiedSection" style="font-size: 10px;">
					<table class="modifiedTable">
						"""),_display_(/*112.8*/for(audit <- auditTrail) yield /*112.32*/ {_display_(Seq[Any](format.raw/*112.34*/("""
							"""),format.raw/*113.8*/("""<tr>
								<td>"""),_display_(/*114.14*/audit/*114.19*/.editor),format.raw/*114.26*/(""" """),format.raw/*114.27*/("""("""),_display_(/*114.29*/audit/*114.34*/.editoremail),format.raw/*114.46*/(""") changed <b>"""),_display_(/*114.60*/audit/*114.65*/.fielddisplay),format.raw/*114.78*/("""</b> from <b>"""),_display_(/*114.92*/audit/*114.97*/.oldvalue),format.raw/*114.106*/("""</b> to <b>"""),_display_(/*114.118*/audit/*114.123*/.newvalue),format.raw/*114.132*/("""</b> on """),_display_(/*114.141*/audit/*114.146*/.editdate),format.raw/*114.155*/(""".</td>
							</tr>
						""")))}),format.raw/*116.8*/("""					
					"""),format.raw/*117.6*/("""</table>
				</div>
			""")))}),format.raw/*119.5*/("""
			"""),format.raw/*120.4*/("""<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}))
      }
    }
  }

  def render(rookieCard:Form[Application.CardAdd],card:Card,teams:java.util.List[Team],lookups:java.util.List[Lookup],auditTrail:java.util.List[CardAudit],allComments:java.util.List[Comment],user:User): play.twirl.api.HtmlFormat.Appendable = apply(rookieCard,card,teams,lookups,auditTrail,allComments,user)

  def f:((Form[Application.CardAdd],Card,java.util.List[Team],java.util.List[Lookup],java.util.List[CardAudit],java.util.List[Comment],User) => play.twirl.api.HtmlFormat.Appendable) = (rookieCard,card,teams,lookups,auditTrail,allComments,user) => apply(rookieCard,card,teams,lookups,auditTrail,allComments,user)

  def ref: this.type = this

}


}

/**/
object editcard extends editcard_Scope0.editcard
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/card/editcard.scala.html
                  HASH: 130b106f34fd662b80db1c18aa8f6614f0851462
                  MATRIX: 879->1|1210->203|1240->243|1268->246|1286->256|1325->258|1354->261|1444->324|1472->325|1506->333|1589->389|1617->390|1649->396|1750->470|1778->471|1812->478|1863->502|1891->503|1932->517|1960->518|1993->524|2021->525|2126->603|2139->607|2170->617|2843->1262|2857->1266|2884->1271|3304->1664|3342->1686|3382->1688|3421->1700|3465->1735|3505->1737|3541->1746|3582->1778|3622->1780|3674->1800|3704->1801|3740->1809|3756->1815|3783->1820|3814->1823|3830->1829|3857->1834|3899->1844|3941->1855|3978->1865|4441->2301|4475->2319|4515->2321|4554->2332|4583->2333|4619->2342|4654->2368|4694->2370|4745->2390|4774->2391|4809->2399|4822->2403|4848->2408|4878->2411|4891->2415|4917->2420|4955->2429|4985->2430|5027->2441|5063->2450|5313->2674|5351->2696|5391->2698|5425->2706|5471->2743|5511->2745|5546->2753|5618->2798|5633->2804|5659->2809|5709->2832|5752->2865|5793->2867|5833->2875|5863->2876|5900->2885|5916->2891|5943->2896|6034->2957|6071->2964|6103->2969|6405->3243|6419->3247|6446->3252|6829->3609|6862->3633|6902->3635|6936->3642|7063->3743|7106->3770|7146->3772|7183->3782|7242->3814|7282->3845|7312->3847|7409->3920|7469->3953|7485->3960|7513->3967|7573->4000|7589->4007|7618->4015|7678->4045|7718->4058|7776->4086|7808->4091|7879->4136|7918->4166|7958->4168|7992->4175|8078->4234|8097->4244|8138->4264|8182->4278|8214->4283|8357->4398|8397->4416|8445->4437|8486->4468|8527->4470|8561->4476|8649->4536|8663->4540|8695->4550|8803->4627|8836->4633|8869->4656|8910->4658|8944->4664|9070->4763|9111->4787|9152->4789|9189->4798|9236->4817|9251->4822|9280->4829|9310->4830|9340->4832|9355->4837|9389->4849|9431->4863|9446->4868|9481->4881|9523->4895|9538->4900|9570->4909|9611->4921|9627->4926|9659->4935|9697->4944|9713->4949|9745->4958|9805->4987|9845->4999|9902->5025|9935->5030
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|37->7|37->7|38->8|38->8|38->8|39->9|39->9|39->9|40->10|41->11|41->11|42->12|42->12|43->13|43->13|45->15|45->15|45->15|58->28|58->28|58->28|67->37|67->37|67->37|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|68->38|69->39|70->40|83->53|83->53|83->53|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|84->54|85->55|86->56|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|96->66|96->66|96->66|96->66|96->66|96->66|96->66|96->66|96->66|98->68|99->69|100->70|103->73|103->73|103->73|111->81|111->81|111->81|112->82|114->84|114->84|114->84|115->85|116->86|116->86|116->86|116->86|117->87|117->87|117->87|118->88|118->88|118->88|120->90|121->91|123->93|124->94|126->96|126->96|126->96|127->97|127->97|127->97|127->97|128->98|129->99|132->102|132->102|134->104|134->104|134->104|135->105|136->106|136->106|136->106|138->108|139->109|139->109|139->109|140->110|142->112|142->112|142->112|143->113|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|144->114|146->116|147->117|149->119|150->120
                  -- GENERATED --
              */
          