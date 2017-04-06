
package views.html.card

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object deletecardconfirm_Scope0 {
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

class deletecardconfirm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Card,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(card: Card):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<section id="deleteCardConfirm">
		<!-- Start Formoid form-->
		<form id="showuser" class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Delete User</h2>
			</div>
			<div class="element-input">
				<label class="title">Player Name:</label>
				<div class="item-cont">
					<input class="large" type="email" name="email" readonly style="color: #a9a9a9;" 
						placeholder="Player Name" value=""""),_display_(/*16.41*/card/*16.45*/.name),format.raw/*16.50*/("""" /><span class="icon-place"></span>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required"></span>The Rookie Card for """),_display_(/*20.77*/card/*20.81*/.name),format.raw/*20.86*/(""" """),format.raw/*20.87*/("""will be deleted.  Please click Delete below to continue or Cancel to stop this process.</label>
			</div>
			<div class="submit">
				<input type="submit" class="deleteButton" style="color: #FFFFFF;" value="Delete" />
				<a href="/" class="buttonCancel">"""),_display_(/*24.39*/Messages("goback")),format.raw/*24.57*/("""</a>
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}),format.raw/*30.2*/("""
"""))
      }
    }
  }

  def render(card:Card): play.twirl.api.HtmlFormat.Appendable = apply(card)

  def f:((Card) => play.twirl.api.HtmlFormat.Appendable) = (card) => apply(card)

  def ref: this.type = this

}


}

/**/
object deletecardconfirm extends deletecardconfirm_Scope0.deletecardconfirm
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/card/deletecardconfirm.scala.html
                  HASH: 1954314d4aff86d880cbfd7e066466d10727d176
                  MATRIX: 772->1|879->13|909->18|927->28|966->30|995->33|1637->648|1650->652|1676->657|1872->826|1885->830|1911->835|1940->836|2227->1096|2266->1114|2413->1231
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|47->16|47->16|47->16|51->20|51->20|51->20|51->20|55->24|55->24|61->30
                  -- GENERATED --
              */
          