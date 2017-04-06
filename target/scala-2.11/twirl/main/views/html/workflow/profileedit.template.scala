
package views.html.workflow

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profileedit_Scope0 {
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

class profileedit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Form[controllers.workflow.ApplicationProfile.NewProfile],java.util.List[models.workflow.WorkflowLookup],java.util.List[models.workflow.WorkflowUser],models.workflow.WorkflowProfile,java.util.List[models.workflow.WorkflowAuditRecord],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(appProfile: Form[controllers.workflow.ApplicationProfile.NewProfile], lookups: java.util.List[models.workflow.WorkflowLookup], users: java.util.List[models.workflow.WorkflowUser], profile: models.workflow.WorkflowProfile, profileAudits: java.util.List[models.workflow.WorkflowAuditRecord]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import java.text.SimpleDateFormat

Seq[Any](format.raw/*1.292*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(null)/*5.12*/ {_display_(Seq[Any](format.raw/*5.14*/("""
	"""),format.raw/*6.2*/("""<section id="appProfile">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS','Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Application Profile</h2>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Application Name:</label>
				<div class="item-cont"><input class="large" type="text" name="appName" required="required" placeholder="Enter the Application Name..." value=""""),_display_(/*15.148*/profile/*15.155*/.getAppName()),format.raw/*15.168*/("""" /><span class="icon-place"></span></div>
			</div>
			<div class="element-input">
				<label class="title"><span></span>Description:</label>
				<div class="item-cont">
					<textarea class="medium" type="text" name="appDesc" placeholder="Enter Description..." value=""""),_display_(/*20.101*/profile/*20.108*/.getAppDesc()),format.raw/*20.121*/("""" /></textarea>
					<span class="icon-place"></span>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Owner:</label>
				<div class="item-cont"><input class="large" type="text" name="appOwner" required="required" placeholder="Enter the Owner Name..." value=""""),_display_(/*26.143*/profile/*26.150*/.getAppOwner()),format.raw/*26.164*/("""" /><span class="icon-place"></span></div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Owner Email:</label>
				<div class="item-cont">
					<input class="large" type="email" name="appOwnerEmail" required="required"
						placeholder="Enter the Owner email..." value=""""),_display_(/*32.54*/profile/*32.61*/.getAppOwnerEmail()),format.raw/*32.80*/("""" /><span class="icon-place"></span>
				</div>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Agency:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="appAgency" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Agency ---</option>
									"""),_display_(/*42.11*/for(lookup <- lookups) yield /*42.33*/ {_display_(Seq[Any](format.raw/*42.35*/("""
										"""),_display_(/*43.12*/if(lookup.getLookupType() == "Agency")/*43.50*/ {_display_(Seq[Any](format.raw/*43.52*/("""
											"""),format.raw/*44.12*/("""{"""),format.raw/*44.13*/("""<option """),_display_(/*44.22*/if(profile.getAppAgency() == lookup.getName())/*44.68*/ {_display_(Seq[Any](format.raw/*44.70*/("""selected="selected"""")))}),format.raw/*44.90*/(""" """),format.raw/*44.91*/("""value=""""),_display_(/*44.99*/lookup/*44.105*/.getName()),format.raw/*44.115*/("""">"""),_display_(/*44.118*/lookup/*44.124*/.getName()),format.raw/*44.134*/("""</option>"""),format.raw/*44.143*/("""}"""),format.raw/*44.144*/("""
										""")))}),format.raw/*45.12*/("""
									""")))}),format.raw/*46.11*/("""	
							"""),format.raw/*47.8*/("""</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<input type="hidden" name="appKey" id="appKey" />
			<div class="element-input">
				"""),_display_(/*55.6*/if(appProfile.hasGlobalErrors)/*55.36*/ {_display_(Seq[Any](format.raw/*55.38*/("""
					"""),format.raw/*56.6*/("""<span class="errorMessageDisplay" style="color: #d9534f;">"""),_display_(/*56.65*/appProfile/*56.75*/.globalError.message),format.raw/*56.95*/("""</span>
				""")))}),format.raw/*57.6*/("""
			"""),format.raw/*58.4*/("""</div>
			<div class="submit">
				<input type="submit" value="Submit" />
				<a href="/" class="buttonCancel">"""),_display_(/*61.39*/Messages("goback")),format.raw/*61.57*/("""</a>
			</div>
			"""),_display_(/*63.5*/if(!profileAudits.isEmpty)/*63.31*/ {_display_(Seq[Any](format.raw/*63.33*/("""
				"""),format.raw/*64.5*/("""<div class="modifiedSection" style="font-size: 10px;">
					<table class="modifiedTable">
						"""),_display_(/*66.8*/for(audit <- profileAudits) yield /*66.35*/ {_display_(Seq[Any](format.raw/*66.37*/("""
							"""),format.raw/*67.8*/("""<tr>
								<td width="25%">"""),_display_(/*68.26*/if(audit.getDateCreated() != null)/*68.60*/{_display_(_display_(/*68.62*/(new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(audit.getDateCreated()))))}),format.raw/*68.138*/("""</td>
								<td width="25%">"""),_display_(/*69.26*/audit/*69.31*/.getAuthor()),format.raw/*69.43*/("""</td>
								<td width="50%">"""),_display_(/*70.26*/audit/*70.31*/.getMessage()),format.raw/*70.44*/("""</td>
							</tr>
						""")))}),format.raw/*72.8*/("""					
					"""),format.raw/*73.6*/("""</table>
				</div>
			""")))}),format.raw/*75.5*/("""
			"""),format.raw/*76.4*/("""<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}))
      }
    }
  }

  def render(appProfile:Form[controllers.workflow.ApplicationProfile.NewProfile],lookups:java.util.List[models.workflow.WorkflowLookup],users:java.util.List[models.workflow.WorkflowUser],profile:models.workflow.WorkflowProfile,profileAudits:java.util.List[models.workflow.WorkflowAuditRecord]): play.twirl.api.HtmlFormat.Appendable = apply(appProfile,lookups,users,profile,profileAudits)

  def f:((Form[controllers.workflow.ApplicationProfile.NewProfile],java.util.List[models.workflow.WorkflowLookup],java.util.List[models.workflow.WorkflowUser],models.workflow.WorkflowProfile,java.util.List[models.workflow.WorkflowAuditRecord]) => play.twirl.api.HtmlFormat.Appendable) = (appProfile,lookups,users,profile,profileAudits) => apply(appProfile,lookups,users,profile,profileAudits)

  def ref: this.type = this

}


}

/**/
object profileedit extends profileedit_Scope0.profileedit
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:51 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/workflow/profileedit.scala.html
                  HASH: f3712ff388efcdfef1ba016f4eccfa4ae36c6c28
                  MATRIX: 992->1|1411->291|1441->331|1469->334|1487->344|1526->346|1555->349|2181->947|2198->954|2233->967|2537->1243|2554->1250|2589->1263|2942->1588|2959->1595|2995->1609|3350->1937|3366->1944|3406->1963|3830->2360|3868->2382|3908->2384|3948->2397|3995->2435|4035->2437|4076->2450|4105->2451|4141->2460|4196->2506|4236->2508|4287->2528|4316->2529|4351->2537|4367->2543|4399->2553|4430->2556|4446->2562|4478->2572|4516->2581|4546->2582|4590->2595|4633->2607|4670->2617|4897->2818|4936->2848|4976->2850|5010->2857|5096->2916|5115->2926|5156->2946|5200->2960|5232->2965|5374->3080|5413->3098|5460->3119|5495->3145|5535->3147|5568->3153|5693->3252|5736->3279|5776->3281|5812->3290|5870->3321|5913->3355|5943->3357|6043->3433|6102->3465|6116->3470|6149->3482|6208->3514|6222->3519|6256->3532|6314->3560|6353->3572|6409->3598|6441->3603
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|45->15|45->15|45->15|50->20|50->20|50->20|56->26|56->26|56->26|62->32|62->32|62->32|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|75->45|76->46|77->47|85->55|85->55|85->55|86->56|86->56|86->56|86->56|87->57|88->58|91->61|91->61|93->63|93->63|93->63|94->64|96->66|96->66|96->66|97->67|98->68|98->68|98->68|98->68|99->69|99->69|99->69|100->70|100->70|100->70|102->72|103->73|105->75|106->76
                  -- GENERATED --
              */
          