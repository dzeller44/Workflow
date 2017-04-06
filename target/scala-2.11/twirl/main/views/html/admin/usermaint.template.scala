
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object usermaint_Scope0 {
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

class usermaint extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Application.Login],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[Application.Login]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.38*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""


"""),format.raw/*6.1*/("""<!-- ABOUT -->
<section id="userMaintenance">

	<!-- SERVICES -->
	<div class="services_block padbot40" data-appear-top-offset="-200"
		data-animated="fadeInUp">

		<!-- CONTAINER -->
		<div class="container">

			<!-- ROW -->
			<div class="row">
				<div class="col-sm-3 margbot30">
					<a class="services_item" href="/adduser">
						<p>
							<img src=""""),_display_(/*21.19*/routes/*21.25*/.Assets.at("/img/icon_Add_User2.png")),format.raw/*21.62*/(""""> <b>Add User</b>
						</p> <span>Add new user...</span>
					</a>
				</div>
				<div class="col-sm-3 margbot30">
					<a class="services_item" href="/finduser">
						<p>
							<img src=""""),_display_(/*28.19*/routes/*28.25*/.Assets.at("/img/icon_Edit_User.png")),format.raw/*28.62*/(""""> <b>Edit User</b>
						</p> <span>Locate and edit a user...</span>
					</a>
				</div>
				<div class="col-sm-3 margbot30">
					<a class="services_item" href="/finduser">
						<p>
							<img src=""""),_display_(/*35.19*/routes/*35.25*/.Assets.at("/img/icon_Delete_User.png")),format.raw/*35.64*/(""""> <b>Delete User</b>
						</p> <span>Locate and delete a user...</span>
					</a>
				</div>
				<div class="col-sm-3 margbot30">
					<a class="services_item" href="/search">
						<p>
						<img src=""""),_display_(/*42.18*/routes/*42.24*/.Assets.at("/img/icon_Search_Records.png")),format.raw/*42.66*/(""""> <b>Search Records</b>
						</p> <span>Search User Records...</span>
					</a>
				</div>
			</div>
		</div>
		<!-- //ROW -->
	</div>
	<!-- //CONTAINER -->
	</div>
	<!-- //SERVICES -->


</section>
<!-- //ABOUT -->

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
object usermaint extends usermaint_Scope0.usermaint
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/usermaint.scala.html
                  HASH: ea0779b4a628b28c710c6e9f27ddbbc09c52729a
                  MATRIX: 776->1|907->37|935->40|953->50|992->52|1021->55|1408->415|1423->421|1481->458|1701->651|1716->657|1774->694|2005->898|2020->904|2080->943|2312->1148|2327->1154|2390->1196
                  LINES: 27->1|32->1|34->3|34->3|34->3|37->6|52->21|52->21|52->21|59->28|59->28|59->28|66->35|66->35|66->35|73->42|73->42|73->42
                  -- GENERATED --
              */
          