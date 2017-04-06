
package views.html.account.settings

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object password_Scope0 {
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

class password extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/views/*5.7*/.html.account.settings.index(user)/*5.41*/ {_display_(Seq[Any](format.raw/*5.43*/("""

    """),_display_(/*7.6*/Messages("account.settings.password")),format.raw/*7.43*/("""

    """),_display_(/*9.6*/wflash()),format.raw/*9.14*/("""

    """),_display_(/*11.6*/form(controllers.account.settings.routes.Password.runPassword())/*11.70*/ {_display_(Seq[Any](format.raw/*11.72*/("""
        """),format.raw/*12.9*/("""<div class="form-actions">
            <input type="submit" class="btn btn-primary" value=""""),_display_(/*13.66*/Messages("reset")),format.raw/*13.83*/("""">
        </div>
    """)))}),format.raw/*15.6*/("""

""")))}))
      }
    }
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}

/**/
object password extends password_Scope0.password
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/settings/password.scala.html
                  HASH: 438deb870b78cf02cdc18c096271d54c2ec9bb25
                  MATRIX: 766->1|888->13|916->32|943->34|955->39|997->73|1036->75|1068->82|1125->119|1157->126|1185->134|1218->141|1291->205|1331->207|1367->216|1486->308|1524->325|1577->348
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|35->5|37->7|37->7|39->9|39->9|41->11|41->11|41->11|42->12|43->13|43->13|45->15
                  -- GENERATED --
              */
          