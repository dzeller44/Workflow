
package views.html.admin

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object showuser_Scope0 {
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

class showuser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[java.util.List[Lookup],User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(lookups: java.util.List[Lookup], user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.47*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

"""),format.raw/*5.1*/("""<section id="signupUser">
	<form class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 550px; min-width: 150px"
		method="post" action=""""),_display_(/*8.26*/routes/*8.32*/.Application.updateUser()),format.raw/*8.57*/("""">
		<div class="title">
			<h2>Update User</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>User
			Name:</label>
			<div class="item-cont">
				<input class="large" type="text" name="fullname" required="required"
					placeholder="Enter the User's Name..." value=""""),_display_(/*17.53*/user/*17.57*/.fullname),format.raw/*17.66*/("""" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>Email:</label>
			<div class="item-cont">
				<input class="large" type="email" name="email" required="required"
					placeholder="Enter the User's email..." value=""""),_display_(/*24.54*/user/*24.58*/.getEmail()),format.raw/*24.69*/("""" /><span class="icon-place"></span>
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
								"""),_display_(/*35.10*/if(lookup.lookuptype == "Role")/*35.41*/ {_display_(Seq[Any](format.raw/*35.43*/("""<option """),_display_(/*35.52*/if(lookup.name == user.rolename)/*35.84*/ {_display_(Seq[Any](format.raw/*35.86*/("""selected="selected"""")))}),format.raw/*35.106*/(""" """),format.raw/*35.107*/("""value=""""),_display_(/*35.115*/lookup/*35.121*/.name),format.raw/*35.126*/("""">"""),_display_(/*35.129*/lookup/*35.135*/.name),format.raw/*35.140*/("""</option>""")))}),format.raw/*35.150*/("""
							""")))}),format.raw/*36.9*/("""	
						"""),format.raw/*37.7*/("""</select>
						<i></i><span class="icon-place"></span>
					</span>
				</div>
			</div>
		</div>
		<div class="submit">
			<input type="submit" value="Submit" />
			<a href="/admin" class="buttonCancel">"""),_display_(/*45.43*/Messages("goback")),format.raw/*45.61*/("""</a>
			<a href="javascript:deleteUser('"""),_display_(/*46.37*/user/*46.41*/.getUserkey()),format.raw/*46.54*/("""')" class="buttonDelete" style="color: #FFFFFF;">Delete</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>
</section>
""")))}),format.raw/*52.2*/("""
"""))
      }
    }
  }

  def render(lookups:java.util.List[Lookup],user:User): play.twirl.api.HtmlFormat.Appendable = apply(lookups,user)

  def f:((java.util.List[Lookup],User) => play.twirl.api.HtmlFormat.Appendable) = (lookups,user) => apply(lookups,user)

  def ref: this.type = this

}


}

/**/
object showuser extends showuser_Scope0.showuser
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/admin/showuser.scala.html
                  HASH: 863d52c03c148665f78d4bad1464767bb8674730
                  MATRIX: 778->1|918->46|948->51|966->61|1005->63|1035->67|1323->329|1337->335|1382->360|1735->686|1748->690|1778->699|2119->1013|2132->1017|2164->1028|2579->1417|2617->1439|2657->1441|2695->1452|2735->1483|2775->1485|2811->1494|2852->1526|2892->1528|2944->1548|2974->1549|3010->1557|3026->1563|3053->1568|3084->1571|3100->1577|3127->1582|3169->1592|3209->1602|3245->1611|3486->1825|3525->1843|3594->1885|3607->1889|3641->1902|3838->2069
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|39->8|39->8|39->8|48->17|48->17|48->17|55->24|55->24|55->24|65->34|65->34|65->34|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|66->35|67->36|68->37|76->45|76->45|77->46|77->46|77->46|83->52
                  -- GENERATED --
              */
          