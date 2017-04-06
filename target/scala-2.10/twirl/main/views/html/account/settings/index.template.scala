
package views.html.account.settings

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[User,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main(user)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""

    """),format.raw/*5.5*/("""<div class="row">
        <div class="col col-lg-4">
            <ul class="nav nav-pills nav-stacked">
                <li>
                    <a href=""""),_display_(/*9.31*/controllers/*9.42*/.account.settings.routes.Password.index),format.raw/*9.81*/("""">"""),_display_(/*9.84*/Messages("password")),format.raw/*9.104*/("""</a>
                </li>
                <li>
                    <a href=""""),_display_(/*12.31*/controllers/*12.42*/.account.settings.routes.Email.index),format.raw/*12.78*/("""">"""),_display_(/*12.81*/Messages("email")),format.raw/*12.98*/("""</a>
                </li>
            </ul>
        </div>
        <div class="col col-lg-8">
        """),_display_(/*17.10*/content),format.raw/*17.17*/("""
        """),format.raw/*18.9*/("""</div>
    </div>
""")))}))
      }
    }
  }

  def render(user:User,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(user)(content)

  def f:((User) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (user) => (content) => apply(user)(content)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/account/settings/index.scala.html
                  HASH: c4f4f29cb988743a05b8df4b648e2bfdb87effee
                  MATRIX: 765->1|887->28|915->31|933->41|972->43|1004->49|1185->204|1204->215|1263->254|1292->257|1333->277|1438->355|1458->366|1515->402|1545->405|1583->422|1714->526|1742->533|1778->542
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|40->9|40->9|40->9|40->9|40->9|43->12|43->12|43->12|43->12|43->12|48->17|48->17|49->18
                  -- GENERATED --
              */
          