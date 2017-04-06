
package views.html.card

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object deletedcard_Scope0 {
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

class deletedcard extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main()/*1.8*/ {_display_(Seq[Any](format.raw/*1.10*/("""
	"""),format.raw/*2.2*/("""<section id="deletedCard">
		<form class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px">
			<div class="title">
				<h2>Success</h2>
			</div>
			<div class="element-input">
				<label class="title"><span class="required"></span>"""),_display_(/*9.57*/Messages("admin.delete.card")),format.raw/*9.86*/("""</label>
			</div>
			<div class="submit">
				<input type="submit" onclick="window.location.href='/'" value="Continue" />
			</div>
			<!-- This is needed for bottom shadow to appear... -->
			<div></div>
		</form>
	</section>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object deletedcard extends deletedcard_Scope0.deletedcard
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:50 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/card/deletedcard.scala.html
                  HASH: 5f04b344ecd246b4f70bf490e8e672303ff06fa4
                  MATRIX: 844->1|857->7|896->9|924->11|1329->390|1378->419
                  LINES: 32->1|32->1|32->1|33->2|40->9|40->9
                  -- GENERATED --
              */
          