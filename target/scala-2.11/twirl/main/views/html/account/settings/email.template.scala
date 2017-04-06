
package views.html.account.settings

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object email_Scope0 {
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

class email extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[User,Form[controllers.account.settings.Email.AskForm],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User, askForm: Form[controllers.account.settings.Email.AskForm]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.73*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/views/*5.7*/.html.account.settings.index(user)/*5.41*/ {_display_(Seq[Any](format.raw/*5.43*/("""

    """),_display_(/*7.6*/Messages("account.settings.email")),format.raw/*7.40*/("""

    """),_display_(/*9.6*/wflash()),format.raw/*9.14*/("""

    """),_display_(/*11.6*/form(controllers.account.settings.routes.Email.runEmail())/*11.64*/ {_display_(Seq[Any](format.raw/*11.66*/("""

        """),format.raw/*13.9*/("""<fieldset>
        """),_display_(/*14.10*/inputText(
            askForm("email"),
            'placeholder -> Messages("email"),
            '_label -> null,
            'class -> "form-control"
        )),format.raw/*19.10*/("""
        """),format.raw/*20.9*/("""</fieldset>

        <div class="form-actions">
            <input type="submit" class="btn btn-primary" value=""""),_display_(/*23.66*/Messages("validate")),format.raw/*23.86*/("""">
        </div>
    """)))}),format.raw/*25.6*/("""

""")))}))
      }
    }
  }

  def render(user:User,askForm:Form[controllers.account.settings.Email.AskForm]): play.twirl.api.HtmlFormat.Appendable = apply(user,askForm)

  def f:((User,Form[controllers.account.settings.Email.AskForm]) => play.twirl.api.HtmlFormat.Appendable) = (user,askForm) => apply(user,askForm)

  def ref: this.type = this

}


}

/**/
object email extends email_Scope0.email
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/settings/email.scala.html
                  HASH: 1e715b40aeebca48c81810872cfc4068688a0187
                  MATRIX: 809->1|990->72|1018->91|1045->93|1057->98|1099->132|1138->134|1170->141|1224->175|1256->182|1284->190|1317->197|1384->255|1424->257|1461->267|1508->287|1692->450|1728->459|1868->572|1909->592|1962->615
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|35->5|37->7|37->7|39->9|39->9|41->11|41->11|41->11|43->13|44->14|49->19|50->20|53->23|53->23|55->25
                  -- GENERATED --
              */
          