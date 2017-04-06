
package views.html.workflow

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object denied_Scope0 {
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

class denied extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main(null)/*1.12*/ {_display_(Seq[Any](format.raw/*1.14*/("""
	"""),format.raw/*2.2*/("""<section id="accessDeniedWorkflow">
		<form id="showuser" class="formoid-solid-dark"
			style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
			method="post" action="">
			<div class="title">
				<h2>Access Denied</h2>
			</div>
			<div class="element-input">
				<label class="title"><span></span>Access has been denied to this page.  You do not have the correct access level.</label>
			</div>					
			<div class="submit">
				<div><a href="/" class="buttonCustom" style="color: #FFFFFF;">Continue</a></div>
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
object denied extends denied_Scope0.denied
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:30 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/workflow/denied.scala.html
                  HASH: b02613daee0ba4ac5b6b505de55896da494e19f0
                  MATRIX: 838->1|856->11|895->13|924->16
                  LINES: 32->1|32->1|32->1|33->2
                  -- GENERATED --
              */
          