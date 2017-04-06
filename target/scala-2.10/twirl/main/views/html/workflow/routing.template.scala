
package views.html.workflow

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object routing_Scope0 {
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

class routing extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[controllers.workflow.ApplicationProfile.NewProfile],java.util.List[models.workflow.WorkflowLookup],java.util.List[models.workflow.WorkflowUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(appProfile: Form[controllers.workflow.ApplicationProfile.NewProfile], lookups: java.util.List[models.workflow.WorkflowLookup], users: java.util.List[models.workflow.WorkflowUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.182*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<section id="appProfile">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS','Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Application Profile</h2>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Application Name:</label>
				<div class="item-cont"><input class="large" type="text" name="appName" required="required" placeholder="Enter the Application Name..."/><span class="icon-place"></span></div>
			</div>
			<div class="element-input">
				<label class="title"><span></span>Description:</label>
				<div class="item-cont">
					<textarea class="medium" type="text" name="appDesc" placeholder="Enter Description..." /></textarea>
					<span class="icon-place"></span>
				</div>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Agency:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="appAgency" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Agency ---</option>
									"""),_display_(/*29.11*/for(lookup <- lookups) yield /*29.33*/ {_display_(Seq[Any](format.raw/*29.35*/("""
										"""),_display_(/*30.12*/if(lookup.getLookupType() == "Agency")/*30.50*/ {_display_(Seq[Any](format.raw/*30.52*/("""
											"""),format.raw/*31.12*/("""<option value=""""),_display_(/*31.28*/lookup/*31.34*/.getName()),format.raw/*31.44*/("""">"""),_display_(/*31.47*/lookup/*31.53*/.getName()),format.raw/*31.63*/("""</option>
										""")))}),format.raw/*32.12*/("""
									""")))}),format.raw/*33.11*/("""	
							"""),format.raw/*34.8*/("""</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Owner:</label>
				<div class="item-cont"><input class="large" type="text" name="appOwner" required="required" placeholder="Enter the Owner Name..."/><span class="icon-place"></span></div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required">*</span>Owner Email:</label>
				<div class="item-cont">
					<input class="large" type="email" name="appOwnerEmail" required="required"
						placeholder="Enter the Owner email..." /><span class="icon-place"></span>
				</div>
			</div>
			<div class="element-select">
				<label class="title"><span class="required">*</span>Agency:</label>
				<div class="item-cont">
					<div class="large">
						<span>
							<select name="appAgency" required="required">
								<option selected="selected" value="" disabled="disabled">--- Select Agency ---</option>
									"""),_display_(/*58.11*/for(lookup <- lookups) yield /*58.33*/ {_display_(Seq[Any](format.raw/*58.35*/("""
										"""),_display_(/*59.12*/if(lookup.getLookupType() == "Agency")/*59.50*/ {_display_(Seq[Any](format.raw/*59.52*/("""
											"""),format.raw/*60.12*/("""<option value=""""),_display_(/*60.28*/lookup/*60.34*/.getName()),format.raw/*60.44*/("""">"""),_display_(/*60.47*/lookup/*60.53*/.getName()),format.raw/*60.63*/("""</option>
										""")))}),format.raw/*61.12*/("""
									""")))}),format.raw/*62.11*/("""	
							"""),format.raw/*63.8*/("""</select>
							<i></i><span class="icon-place"></span>
						</span>
					</div>
				</div>
			</div>
			<input type="hidden" name="appKey" id="appKey" />
			<div class="element-input">
				"""),_display_(/*71.6*/if(appProfile.hasGlobalErrors)/*71.36*/ {_display_(Seq[Any](format.raw/*71.38*/("""
					"""),format.raw/*72.6*/("""<span class="errorMessageDisplay" style="color: #d9534f;">"""),_display_(/*72.65*/appProfile/*72.75*/.globalError.message),format.raw/*72.95*/("""</span>
				""")))}),format.raw/*73.6*/("""
			"""),format.raw/*74.4*/("""</div>
			<div class="submit">
				<input type="submit" value="Submit" />
				<a href="/" class="buttonCancel">"""),_display_(/*77.39*/Messages("goback")),format.raw/*77.57*/("""</a>
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}))
      }
    }
  }

  def render(appProfile:Form[controllers.workflow.ApplicationProfile.NewProfile],lookups:java.util.List[models.workflow.WorkflowLookup],users:java.util.List[models.workflow.WorkflowUser]): play.twirl.api.HtmlFormat.Appendable = apply(appProfile,lookups,users)

  def f:((Form[controllers.workflow.ApplicationProfile.NewProfile],java.util.List[models.workflow.WorkflowLookup],java.util.List[models.workflow.WorkflowUser]) => play.twirl.api.HtmlFormat.Appendable) = (appProfile,lookups,users) => apply(appProfile,lookups,users)

  def ref: this.type = this

}


}

/**/
object routing extends routing_Scope0.routing
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/workflow/routing.scala.html
                  HASH: 232b8d6a2c81183c5394cfab01b640a449bf262e
                  MATRIX: 900->1|1176->181|1206->186|1224->196|1263->198|1292->201|2587->1469|2625->1491|2665->1493|2705->1506|2752->1544|2792->1546|2833->1559|2876->1575|2891->1581|2922->1591|2952->1594|2967->1600|2998->1610|3051->1632|3094->1644|3131->1654|4218->2714|4256->2736|4296->2738|4336->2751|4383->2789|4423->2791|4464->2804|4507->2820|4522->2826|4553->2836|4583->2839|4598->2845|4629->2855|4682->2877|4725->2889|4762->2899|4989->3100|5028->3130|5068->3132|5102->3139|5188->3198|5207->3208|5248->3228|5292->3242|5324->3247|5466->3362|5505->3380
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|60->29|60->29|60->29|61->30|61->30|61->30|62->31|62->31|62->31|62->31|62->31|62->31|62->31|63->32|64->33|65->34|89->58|89->58|89->58|90->59|90->59|90->59|91->60|91->60|91->60|91->60|91->60|91->60|91->60|92->61|93->62|94->63|102->71|102->71|102->71|103->72|103->72|103->72|103->72|104->73|105->74|108->77|108->77
                  -- GENERATED --
              */
          