
package views.html.account.signup

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object createFormOnly_Scope0 {
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

class createFormOnly extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Application.Register],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(signupForm: Form[Application.Register]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._
implicit def /*4.6*/implicitFieldConstructor/*4.30*/ = {{
        FieldConstructor(twitterBootstrapInput.render)
    }};
Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*4.1*/("""    """),format.raw/*6.6*/("""

"""),format.raw/*8.1*/("""<h3>"""),_display_(/*8.6*/Messages("signup.new")),format.raw/*8.28*/("""</h3>

"""),_display_(/*10.2*/form(controllers.account.routes.Signup.save())/*10.48*/ {_display_(Seq[Any](format.raw/*10.50*/("""

    """),format.raw/*12.5*/("""<fieldset>
        """),_display_(/*13.10*/inputText(
            signupForm("email"),
            'placeholder -> Messages("email"),
            '_label -> null,
            'class -> "form-control"
        )),format.raw/*18.10*/("""
        """),_display_(/*19.10*/inputText(
            signupForm("fullname"),
            'placeholder -> Messages("fullname"),
            '_label -> null,
            'class -> "form-control"
        )),format.raw/*24.10*/("""
        """),_display_(/*25.10*/inputPassword(
            signupForm("inputPassword"),
            '_label -> null,
            'placeholder -> Messages("password"),
            'class -> "form-control"
        )),format.raw/*30.10*/("""
    """),format.raw/*31.5*/("""</fieldset>

    <div class="form-actions">
        <input type="submit" class="btn btn-primary" value=""""),_display_(/*34.62*/Messages("signup.signup")),format.raw/*34.87*/("""">
    </div>
""")))}),format.raw/*36.2*/("""

"""))
      }
    }
  }

  def render(signupForm:Form[Application.Register]): play.twirl.api.HtmlFormat.Appendable = apply(signupForm)

  def f:((Form[Application.Register]) => play.twirl.api.HtmlFormat.Appendable) = (signupForm) => apply(signupForm)

  def ref: this.type = this

}


}

/**/
object createFormOnly extends createFormOnly_Scope0.createFormOnly
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/signup/createFormOnly.scala.html
                  HASH: 8294e781bfba48c1898ee063ccd02dbcac73716e
                  MATRIX: 798->1|940->65|972->89|1068->41|1096->60|1126->155|1154->157|1184->162|1226->184|1260->192|1315->238|1355->240|1388->246|1435->266|1622->432|1659->442|1852->614|1889->624|2091->805|2123->810|2255->915|2301->940|2346->955
                  LINES: 27->1|31->4|31->4|34->1|36->4|36->6|38->8|38->8|38->8|40->10|40->10|40->10|42->12|43->13|48->18|49->19|54->24|55->25|60->30|61->31|64->34|64->34|66->36
                  -- GENERATED --
              */
          