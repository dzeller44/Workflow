
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object useraccount_Scope0 {
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

class useraccount extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[Application.FindUser],String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(findUserForm: Form[Application.FindUser], userEmail: String, userName: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.81*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

"""),format.raw/*5.1*/("""<section id="signup">
	<!-- Start Formoid form-->
	<form id="showuser" class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action=""""),_display_(/*9.26*/routes/*9.32*/.Application.updateUserAccount()),format.raw/*9.64*/("""">
		<div class="title">
			<h2>User Account</h2>
		</div>
		<div class="element-input">
			<label class="title"><span class="required">*</span>User
				Name:</label>
			<div class="item-cont">
				<input class="large" type="text" name="fullname" required="required" 
					placeholder="Choose a user name..." value=""""),_display_(/*18.50*/userName),format.raw/*18.58*/("""" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
			<label class="title">Email:</label>
			<div class="item-cont">
				<input class="large" type="email" name="email" readonly style="color: #dddddd;" 
					placeholder="Enter your email..." value=""""),_display_(/*25.48*/userEmail),format.raw/*25.57*/("""" /><span class="icon-place"></span>
			</div>
		</div>
		<div class="element-input">
		    """),_display_(/*29.8*/if(findUserForm.hasGlobalErrors)/*29.40*/ {_display_(Seq[Any](format.raw/*29.42*/("""
        		"""),format.raw/*30.11*/("""<span class="errorMessageDisplay" style="color: #d9534f;">
            		"""),_display_(/*31.16*/findUserForm/*31.28*/.globalError.message),format.raw/*31.48*/("""
        		"""),format.raw/*32.11*/("""</span>
   			""")))}),format.raw/*33.8*/("""
		"""),format.raw/*34.3*/("""</div>
		<div class="submit">
			<input type="submit" value="""),_display_(/*36.32*/Messages("submit")),format.raw/*36.50*/(""" """),format.raw/*36.51*/("""/>
			<a href="/admin" class="buttonCancel">"""),_display_(/*37.43*/Messages("goback")),format.raw/*37.61*/("""</a>
		</div>
		<!-- This is needed for bottom shadow to appear... -->
		<div></div>
	</form>
	<div class="loginBlock">
		<a href="/reset/ask"><div class="loginText">"""),_display_(/*43.48*/Messages("forgot.password")),format.raw/*43.75*/("""</div></a>
	</div>
</section>

""")))}),format.raw/*47.2*/("""
"""))
      }
    }
  }

  def render(findUserForm:Form[Application.FindUser],userEmail:String,userName:String): play.twirl.api.HtmlFormat.Appendable = apply(findUserForm,userEmail,userName)

  def f:((Form[Application.FindUser],String,String) => play.twirl.api.HtmlFormat.Appendable) = (findUserForm,userEmail,userName) => apply(findUserForm,userEmail,userName)

  def ref: this.type = this

}


}

/**/
object useraccount extends useraccount_Scope0.useraccount
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/useraccount.scala.html
                  HASH: 143954a62fc49159de43043e80c66a760815f8e2
                  MATRIX: 791->1|965->80|995->85|1013->95|1052->97|1082->101|1409->402|1423->408|1475->440|1828->766|1857->774|2175->1065|2205->1074|2328->1171|2369->1203|2409->1205|2449->1217|2551->1292|2572->1304|2613->1324|2653->1336|2699->1352|2730->1356|2820->1419|2859->1437|2888->1438|2961->1484|3000->1502|3200->1675|3248->1702|3314->1738
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|40->9|40->9|40->9|49->18|49->18|56->25|56->25|60->29|60->29|60->29|61->30|62->31|62->31|62->31|63->32|64->33|65->34|67->36|67->36|67->36|68->37|68->37|74->43|74->43|78->47
                  -- GENERATED --
              */
          