
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object deleteconfirm_Scope0 {
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

class deleteconfirm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<section id="deleteUserConfirm">
		<!-- Start Formoid form-->
		<form id="showuser" class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Delete User</h2>
			</div>
			<div class="element-input">
				<label class="title">Email:</label>
				<div class="item-cont">
					<input class="large" type="email" name="email" readonly style="color: #a9a9a9;" 
						placeholder="Enter your email..." value="""),_display_(/*16.48*/user/*16.52*/.getEmail()),format.raw/*16.63*/(""" """),format.raw/*16.64*/("""/><span class="icon-place"></span>
				</div>
			</div>
			<div class="element-input">
				<label class="title"><span class="required"></span>The User Account for """),_display_(/*20.78*/user/*20.82*/.getEmail()),format.raw/*20.93*/(""" """),format.raw/*20.94*/("""will be deleted.  Please click Delete below to continue or Cancel to stop this process.</label>
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

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}

/**/
object deleteconfirm extends deleteconfirm_Scope0.deleteconfirm
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/deleteconfirm.scala.html
                  HASH: a9db444a4178f0869d159f86b3f69db67c43caac
                  MATRIX: 765->1|872->13|902->18|920->28|959->30|988->33|1631->649|1644->653|1676->664|1705->665|1900->833|1913->837|1945->848|1974->849|2261->1109|2300->1127|2447->1244
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|47->16|47->16|47->16|47->16|51->20|51->20|51->20|51->20|55->24|55->24|61->30
                  -- GENERATED --
              */
          