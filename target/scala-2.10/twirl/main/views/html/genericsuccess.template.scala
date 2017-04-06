
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object genericsuccess_Scope0 {
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

class genericsuccess extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main(null)/*1.12*/ {_display_(Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*3.1*/("""<section id="genericSuccess">
	<form id="showuser" class="formoid-solid-dark"
		style="background-color: #FFFFFF; font-size: 14px; font-family: 'Trebuchet MS', 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
		method="post" action="">
		<div class="title">
			<h2>Success!</h2>
		</div>
		<div class="element-input">
			<label class="title"><span></span>Success</label>
		</div>				
		<div class="submit">
			<a href="/" class="buttonCancel">"""),_display_(/*14.38*/Messages("goback")),format.raw/*14.56*/("""</a>
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
object genericsuccess extends genericsuccess_Scope0.genericsuccess
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/genericsuccess.scala.html
                  HASH: 34e96d0da7f01b7d000b5f1e584148bb0d5e177d
                  MATRIX: 845->1|863->11|902->13|932->17|1457->515|1496->533
                  LINES: 32->1|32->1|32->1|34->3|45->14|45->14
                  -- GENERATED --
              */
          