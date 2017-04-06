
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object displayuser_Scope0 {
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

class displayuser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Form[User],String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(findUserForm: Form[User], userEmail: String, userName: String, userRole: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.83*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

"""),format.raw/*5.1*/("""<section id="signup">
	<!-- Start Formoid form-->
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action="">
		<div class="title">
			<h2>User Maintenance</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>User
				Name:</label>
			<div class="item-cont">
				<input class="large" type="text" name="fullname" required="required" 
					placeholder="Choose a user name..." value="""),_display_(/*18.49*/userName),format.raw/*18.57*/(""" """),format.raw/*18.58*/("""/><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title">Email:</label>
			<div class="item-cont">
				<input class="large" type="email" name="email" readonly style="color: #dddddd;" 
					placeholder="Enter your email..." value="""),_display_(/*25.47*/userEmail),format.raw/*25.56*/(""" """),format.raw/*25.57*/("""/><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-select">
			<label class="title"><span class="required">*</span>Account
			Role:</label>
			<div class="item-cont">
				<div class="large">
					<span>
						<select name="role" value="""),_display_(/*34.34*/userRole),format.raw/*34.42*/(""" """),format.raw/*34.43*/("""required="required">
						"""),_display_(/*35.8*/if(userRole == "user")/*35.30*/ {_display_(Seq[Any](format.raw/*35.32*/("""
							"""),format.raw/*36.8*/("""<option value="none">Select Role...</option>
							<option value="user" selected>Business User</option>
							<option value="manager">Emergency Manager</option>
						""")))}),format.raw/*39.8*/("""
						"""),format.raw/*40.7*/("""else """),format.raw/*40.12*/("""{"""),format.raw/*40.13*/("""
							"""),format.raw/*41.8*/("""<option value="none">Select Role...</option>
							<option value="user">Business User</option>
							<option value="manager" selected>Emergency Manager</option>
						"""),format.raw/*44.7*/("""}"""),format.raw/*44.8*/("""
						"""),format.raw/*45.7*/("""</select>
						<i></i><span class="icon-place"></span>
					</span>
				</div>
			</div>
		</div>
		
		<div class="element-checkbox">
			<div class="column column1">
				<label><input type="checkbox" name="approved"
					value="approve" /><span>Approve Emergency Manager Account</span></label>
			</div>
			<span class="clearfix"></span>
		</div>
		
		<div class="element-input">
		    """),_display_(/*61.8*/if(findUserForm.hasGlobalErrors)/*61.40*/ {_display_(Seq[Any](format.raw/*61.42*/("""
        		"""),format.raw/*62.11*/("""<span class="errorMessageDisplay" style="color: #d9534f;">
            		"""),_display_(/*63.16*/findUserForm/*63.28*/.globalError.message),format.raw/*63.48*/("""
        		"""),format.raw/*64.11*/("""</span>
   			""")))}),format.raw/*65.8*/("""
		"""),format.raw/*66.3*/("""</div>
		<div class="submit">
			<a href="/saveuser" class="buttonCustom" style="color: #FFFFFF;">"""),_display_(/*68.70*/Messages("submit")),format.raw/*68.88*/("""</a>
			<a href="/" class="buttonCancel">"""),_display_(/*69.38*/Messages("goback")),format.raw/*69.56*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>

</section>

""")))}),format.raw/*77.2*/("""
"""))
      }
    }
  }

  def render(findUserForm:Form[User],userEmail:String,userName:String,userRole:String): play.twirl.api.HtmlFormat.Appendable = apply(findUserForm,userEmail,userName,userRole)

  def f:((Form[User],String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (findUserForm,userEmail,userName,userRole) => apply(findUserForm,userEmail,userName,userRole)

  def ref: this.type = this

}


}

/**/
object displayuser extends displayuser_Scope0.displayuser
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/displayuser.scala.html
                  HASH: 6ee907e95f25b742227b4af287b5a8ac929ae36f
                  MATRIX: 788->1|964->82|994->87|1012->97|1051->99|1081->103|1723->718|1752->726|1781->727|2096->1015|2126->1024|2155->1025|2452->1295|2481->1303|2510->1304|2565->1333|2596->1355|2636->1357|2672->1366|2875->1539|2910->1547|2943->1552|2972->1553|3008->1562|3207->1734|3235->1735|3270->1743|3700->2147|3741->2179|3781->2181|3821->2193|3923->2268|3944->2280|3985->2300|4025->2312|4071->2328|4102->2332|4230->2433|4269->2451|4339->2494|4378->2512|4524->2628
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|49->18|49->18|49->18|56->25|56->25|56->25|65->34|65->34|65->34|66->35|66->35|66->35|67->36|70->39|71->40|71->40|71->40|72->41|75->44|75->44|76->45|92->61|92->61|92->61|93->62|94->63|94->63|94->63|95->64|96->65|97->66|99->68|99->68|100->69|100->69|108->77
                  -- GENERATED --
              */
          