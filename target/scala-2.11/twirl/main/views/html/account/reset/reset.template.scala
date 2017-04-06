
package views.html.account.reset

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object reset_Scope0 {
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

class reset extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[controllers.account.Reset.ResetForm],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(resetForm: Form[controllers.account.Reset.ResetForm], token: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._
implicit def /*4.6*/implicitFieldConstructor/*4.30*/ = {{
        FieldConstructor(twitterBootstrapInput.render)
    }};
Seq[Any](format.raw/*1.71*/("""

"""),format.raw/*4.1*/("""    """),format.raw/*6.6*/("""

"""),_display_(/*8.2*/main(null)/*8.12*/ {_display_(Seq[Any](format.raw/*8.14*/("""
	"""),format.raw/*9.2*/("""<script src=""""),_display_(/*9.16*/routes/*9.22*/.Assets.at("js/jquery/jquery-latest.js")),format.raw/*9.62*/("""" type="text/javascript"></script>
	<script>
	
		jQuery(function()"""),format.raw/*12.20*/("""{"""),format.raw/*12.21*/("""
        """),format.raw/*13.9*/("""$("#submit").click(function()"""),format.raw/*13.38*/("""{"""),format.raw/*13.39*/("""
        """),format.raw/*14.9*/("""$(".error").hide();
        var hasError = false;
        var passwordVal = $("#password").val();
        var checkVal = $("#password-check").val();
        if (passwordVal == '') """),format.raw/*18.32*/("""{"""),format.raw/*18.33*/("""
            """),format.raw/*19.13*/("""$("#password").after('<span class="error">Please enter a password.</span>');
            hasError = true;
        """),format.raw/*21.9*/("""}"""),format.raw/*21.10*/(""" """),format.raw/*21.11*/("""else if (checkVal == '') """),format.raw/*21.36*/("""{"""),format.raw/*21.37*/("""
            """),format.raw/*22.13*/("""$("#password-check").after('<span class="error">Please re-enter your password.</span>');
            hasError = true;
        """),format.raw/*24.9*/("""}"""),format.raw/*24.10*/(""" """),format.raw/*24.11*/("""else if (passwordVal != checkVal ) """),format.raw/*24.46*/("""{"""),format.raw/*24.47*/("""
            """),format.raw/*25.13*/("""$("#password-check").after('<span class="error">Passwords do not match.</span>');
            hasError = true;
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/("""
        """),format.raw/*28.9*/("""if(hasError == true) """),format.raw/*28.30*/("""{"""),format.raw/*28.31*/("""return false;"""),format.raw/*28.44*/("""}"""),format.raw/*28.45*/("""
    		"""),format.raw/*29.7*/("""}"""),format.raw/*29.8*/(""");
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""");

	</script>


	<section id="resetPasswordChange">
		<!-- Start Formoid form-->
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>"""),_display_(/*41.10*/Messages("resetpassword.new.password")),format.raw/*41.48*/("""</h2>
			</div>
			
			
		<div class="element-password">
			<label class="title"><span class="required">*</span>Password:</label>
			<div class="item-cont">
				<input class="large" type="password" name="password" id="password" value=""
					required="required" placeholder="Enter your password..." /><span
					class="icon-place"></span>
			</div>
		</div>
		
		<div class="element-password">
	         <label class="title"><span class="required">*</span>Re-enter Password:</label>
	         <div class="item-cont">
	            <input class="large" type="password" name="password-check" id="password-check" value=""
	               required="required" placeholder="Re-enter password..." /><span
	               class="icon-place"></span>
	         </div>
	      </div>
		
		<div class="element-input">
		    """),_display_(/*64.8*/if(resetForm.hasGlobalErrors)/*64.37*/ {_display_(Seq[Any](format.raw/*64.39*/("""
        		"""),format.raw/*65.11*/("""<span class="errorMessageDisplay" style="color: #d9534f;">
            		"""),_display_(/*66.16*/resetForm/*66.25*/.globalError.message),format.raw/*66.45*/("""
        		"""),format.raw/*67.11*/("""</span>
   			""")))}),format.raw/*68.8*/("""
		"""),format.raw/*69.3*/("""</div>
			<div class="submit">
				<input type="submit" value=""""),_display_(/*71.34*/Messages("validate")),format.raw/*71.54*/("""" id="submit"/>
				<a href="/" class="buttonCancel">"""),_display_(/*72.39*/Messages("goback")),format.raw/*72.57*/("""</a>
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>

	</section>

""")))}),format.raw/*80.2*/("""
"""))
      }
    }
  }

  def render(resetForm:Form[controllers.account.Reset.ResetForm],token:String): play.twirl.api.HtmlFormat.Appendable = apply(resetForm,token)

  def f:((Form[controllers.account.Reset.ResetForm],String) => play.twirl.api.HtmlFormat.Appendable) = (resetForm,token) => apply(resetForm,token)

  def ref: this.type = this

}


}

/**/
object reset extends reset_Scope0.reset
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/reset/reset.scala.html
                  HASH: 2ce94bde93664179285bae39e0c85c2a0113eb05
                  MATRIX: 801->1|972->97|1004->121|1102->70|1132->92|1162->189|1192->194|1210->204|1249->206|1278->209|1318->223|1332->229|1392->269|1489->338|1518->339|1555->349|1612->378|1641->379|1678->389|1890->573|1919->574|1961->588|2104->704|2133->705|2162->706|2215->731|2244->732|2286->746|2441->874|2470->875|2499->876|2562->911|2591->912|2633->926|2781->1047|2810->1048|2847->1058|2896->1079|2925->1080|2966->1093|2995->1094|3030->1102|3058->1103|3091->1109|3119->1110|3509->1473|3568->1511|4428->2345|4466->2374|4506->2376|4546->2388|4648->2463|4666->2472|4707->2492|4747->2504|4793->2520|4824->2524|4917->2590|4958->2610|5040->2665|5079->2683|5230->2804
                  LINES: 27->1|31->4|31->4|34->1|36->4|36->6|38->8|38->8|38->8|39->9|39->9|39->9|39->9|42->12|42->12|43->13|43->13|43->13|44->14|48->18|48->18|49->19|51->21|51->21|51->21|51->21|51->21|52->22|54->24|54->24|54->24|54->24|54->24|55->25|57->27|57->27|58->28|58->28|58->28|58->28|58->28|59->29|59->29|60->30|60->30|71->41|71->41|94->64|94->64|94->64|95->65|96->66|96->66|96->66|97->67|98->68|99->69|101->71|101->71|102->72|102->72|110->80
                  -- GENERATED --
              */
          