
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object createuser_Scope0 {
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

class createuser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[Application.RegisterUser],java.util.List[Lookup],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(registerUserForm: Form[Application.RegisterUser], lookups: java.util.List[Lookup]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.85*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

"""),format.raw/*5.1*/("""<section id="signupUser">
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action="">
		<div class="title">
			<h2>New User</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>User
			Name:</label>
			<div class="item-cont">
				<input class="large" type="text" name="fullname" required="required"
					placeholder="Enter the User's Name..." /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>Email:</label>
			<div class="item-cont">
				<input class="large" type="email" name="email" required="required"
					placeholder="Enter the User's email..." /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-select">
			<label class="title"><span class="required">*</span>Account Role:</label>
			<div class="item-cont">
				<div class="large">
					<span>
						<select name="rolename" required="required">
							<option selected="selected" value="" disabled="disabled">--- Select Role ---</option>
							"""),_display_(/*34.9*/for(lookup <- lookups) yield /*34.31*/ {_display_(Seq[Any](format.raw/*34.33*/("""
								"""),_display_(/*35.10*/if(lookup.lookuptype == "Role")/*35.41*/ {_display_(Seq[Any](format.raw/*35.43*/("""<option value=""""),_display_(/*35.59*/lookup/*35.65*/.name),format.raw/*35.70*/("""">"""),_display_(/*35.73*/lookup/*35.79*/.name),format.raw/*35.84*/("""</option>""")))}),format.raw/*35.94*/("""
							""")))}),format.raw/*36.9*/("""	
						"""),format.raw/*37.7*/("""</select>
						<i></i><span class="icon-place"></span>
					</span>
				</div>
			</div>
		</div>
		<div class="element-input">
			"""),_display_(/*44.5*/if(registerUserForm.hasGlobalErrors)/*44.41*/ {_display_(Seq[Any](format.raw/*44.43*/("""
				"""),format.raw/*45.5*/("""<span class="errorMessageDisplay" style="color: #d9534f;">"""),_display_(/*45.64*/registerUserForm/*45.80*/.globalError.message),format.raw/*45.100*/("""</span>
			""")))}),format.raw/*46.5*/("""
		"""),format.raw/*47.3*/("""</div>
		<div class="submit">
			<input type="submit" value="Submit" /> <a href="/admin"
				class="buttonCancel">"""),_display_(/*50.27*/Messages("goback")),format.raw/*50.45*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>
</section>
""")))}),format.raw/*56.2*/("""
"""))
      }
    }
  }

  def render(registerUserForm:Form[Application.RegisterUser],lookups:java.util.List[Lookup]): play.twirl.api.HtmlFormat.Appendable = apply(registerUserForm,lookups)

  def f:((Form[Application.RegisterUser],java.util.List[Lookup]) => play.twirl.api.HtmlFormat.Appendable) = (registerUserForm,lookups) => apply(registerUserForm,lookups)

  def ref: this.type = this

}


}

/**/
object createuser extends createuser_Scope0.createuser
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/createuser.scala.html
                  HASH: 601df89817630eef545d38604f9e2457072f9280
                  MATRIX: 808->1|986->84|1014->87|1032->97|1071->99|1099->101|2363->1339|2401->1361|2441->1363|2478->1373|2518->1404|2558->1406|2601->1422|2616->1428|2642->1433|2672->1436|2687->1442|2713->1447|2754->1457|2793->1466|2828->1474|2987->1607|3032->1643|3072->1645|3104->1650|3190->1709|3215->1725|3257->1745|3299->1757|3329->1760|3471->1875|3510->1893|3646->1999
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|65->34|65->34|65->34|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|67->36|68->37|75->44|75->44|75->44|76->45|76->45|76->45|76->45|77->46|78->47|81->50|81->50|87->56
                  -- GENERATED --
              */
          