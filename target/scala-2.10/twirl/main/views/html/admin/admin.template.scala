
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object admin_Scope0 {
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

class admin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Application.Login],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[Application.Login]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.38*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<section id="adminMain">
		<div class="services_block padbot40" data-appear-top-offset="-200">
			<div class="container">
				<div class="row">
					<div class="col-sm-4 margbot30">
						<a class="services_item" href="/searchcards">
							<p>
								<img src=""""),_display_(/*11.20*/routes/*11.26*/.Assets.at("/img/icon_Search_Records.png")),format.raw/*11.68*/(""""> <b>All Cards</b>
							</p> <span>Add/Edit/Delete/Search Cards...</span>
						</a>
					</div>
					<div class="col-sm-4 margbot30">
						<a class="services_item" href="/adminuser">
							<p>
								<img src=""""),_display_(/*18.20*/routes/*18.26*/.Assets.at("/img/icon_User_Maint.png")),format.raw/*18.64*/(""""> <b>User Maintenance</b>
							</p> <span>Add/Edit/Delete User Records...</span>
						</a>
					</div>
					<div class="col-sm-4 margbot30">
						<a class="services_item" href="/tablemaint">
							<p>
								<img src=""""),_display_(/*25.20*/routes/*25.26*/.Assets.at("/img/icon_Export_Data.png")),format.raw/*25.65*/(""""> <b>Lookup/Table Maintenance</b>
							</p> <span>Add/Edit Lookup Records...</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
""")))}))
      }
    }
  }

  def render(loginForm:Form[Application.Login]): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)

  def f:((Form[Application.Login]) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)

  def ref: this.type = this

}


}

/**/
object admin extends admin_Scope0.admin
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/admin.scala.html
                  HASH: 345d3106e8afeeb23ea2dd1805230ff7901d06fd
                  MATRIX: 768->1|899->37|927->40|945->50|984->52|1012->54|1303->318|1318->324|1381->366|1626->584|1641->590|1700->628|1953->854|1968->860|2028->899
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|42->11|42->11|42->11|49->18|49->18|49->18|56->25|56->25|56->25
                  -- GENERATED --
              */
          