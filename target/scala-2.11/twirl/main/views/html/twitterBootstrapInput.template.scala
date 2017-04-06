
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object twitterBootstrapInput_Scope0 {
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

class twitterBootstrapInput extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[helper.FieldElements,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(elements: helper.FieldElements):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*5.4*/("""
"""),format.raw/*6.1*/("""<div class="form-group """),_display_(/*6.25*/if(elements.hasErrors)/*6.47*/ {_display_(Seq[Any](format.raw/*6.49*/("""error""")))}),format.raw/*6.55*/("""">
    <label for=""""),_display_(/*7.18*/elements/*7.26*/.id),format.raw/*7.29*/("""">"""),_display_(/*7.32*/elements/*7.40*/.label),format.raw/*7.46*/("""</label>
    """),_display_(/*8.6*/elements/*8.14*/.input),format.raw/*8.20*/("""
    """),format.raw/*9.5*/("""<p class="help-inline">"""),_display_(/*9.29*/elements/*9.37*/.infos.mkString(", ")),format.raw/*9.58*/("""</p>
    """),_display_(/*10.6*/if(elements.hasErrors)/*10.28*/ {_display_(Seq[Any](format.raw/*10.30*/("""
        """),format.raw/*11.9*/("""<p class="help-inline">"""),_display_(/*11.33*/elements/*11.41*/.errors.mkString(", ")),format.raw/*11.63*/("""</p>
    """)))}),format.raw/*12.6*/("""
"""),format.raw/*13.1*/("""</div>"""))
      }
    }
  }

  def render(elements:helper.FieldElements): play.twirl.api.HtmlFormat.Appendable = apply(elements)

  def f:((helper.FieldElements) => play.twirl.api.HtmlFormat.Appendable) = (elements) => apply(elements)

  def ref: this.type = this

}


}

/**/
object twitterBootstrapInput extends twitterBootstrapInput_Scope0.twitterBootstrapInput
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/twitterBootstrapInput.scala.html
                  HASH: fd7acefa8416986502a99805f451d3ad454a23fe
                  MATRIX: 791->1|918->33|946->96|973->97|1023->121|1053->143|1092->145|1128->151|1174->171|1190->179|1213->182|1242->185|1258->193|1284->199|1323->213|1339->221|1365->227|1396->232|1446->256|1462->264|1503->285|1539->295|1570->317|1610->319|1646->328|1697->352|1714->360|1757->382|1797->392|1825->393
                  LINES: 27->1|32->1|34->5|35->6|35->6|35->6|35->6|35->6|36->7|36->7|36->7|36->7|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|40->11|41->12|42->13
                  -- GENERATED --
              */
          