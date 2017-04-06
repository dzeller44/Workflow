
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object home_Scope0 {
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

class home extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main()/*1.8*/ {_display_(Seq[Any](format.raw/*1.10*/("""
	"""),format.raw/*2.2*/("""<section id="homePage">
		<div class="services_block padbot40" data-appear-top-offset="-200">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 margbot30">
						<a class="services_item" href="/addcard">
							<p>
								<img src=""""),_display_(/*9.20*/routes/*9.26*/.Assets.at("/img/icon_Add_Profile.png")),format.raw/*9.65*/(""""> <b>Add Rookie Card</b>
							</p> <span>Add a new Rookie Card...</span>
						</a>
					</div>
					<div class="col-sm-6 margbot30">
						<a class="services_item" href="/searchcards">
							<p>
								<img src=""""),_display_(/*16.20*/routes/*16.26*/.Assets.at("/img/icon_Edit_Profile.png")),format.raw/*16.66*/(""""> <b>View Rookie Cards</b>
							</p> <span>View All Rookie Cards...</span>
						</a>
					</div>
	
				</div>
			</div>
		</div>
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
object home extends home_Scope0.home
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/home.scala.html
                  HASH: 7112f5d4575cfb701315b98a982e311d3e13b0ad
                  MATRIX: 825->1|838->7|877->9|905->11|1190->270|1204->276|1263->315|1509->534|1524->540|1585->580
                  LINES: 32->1|32->1|32->1|33->2|40->9|40->9|40->9|47->16|47->16|47->16
                  -- GENERATED --
              */
          