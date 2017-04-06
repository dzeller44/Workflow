
package views.html

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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[Application.Register],Form[Application.Login],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(signupForm: Form[Application.Register], loginForm: Form[Application.Login]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.78*/("""

"""),_display_(/*3.2*/main(null)/*3.12*/ {_display_(Seq[Any](format.raw/*3.14*/("""
	"""),format.raw/*4.2*/("""<section id="indexPage">
		<div class="container">
			<h2><b>Welcome to Dan's Rookie Cards</h2>
			<div class="testimonials" data-appear-top-offset="-200" data-animated="fadeInUp">
				<br><br>
				<div class="container">
					<div class="row">
						<div class="col-sm-4 margbot30">
							<a class="services_item" href="/signup">
								<p>
									<img src=""""),_display_(/*14.21*/routes/*14.27*/.Assets.at("/img/icon_Add_User.png")),format.raw/*14.63*/(""""> <b>Create New Account</b>
								</p>
								<span>Register for an account...</span>
							</a>
						</div>
						<div class="col-sm-4 margbot30">
							<a class="services_item" href="/auth">
								<p>
									<img src=""""),_display_(/*22.21*/routes/*22.27*/.Assets.at("/img/icon_Sign_In.png")),format.raw/*22.62*/(""""> <b>Sign In</b>
								</p>
								<span>Existing users log in here...</span>
							</a>
						</div>
						<div class="col-sm-4 margbot30">
							<a class="services_item" href="/reset/ask">
								<p>
									<img src=""""),_display_(/*30.21*/routes/*30.27*/.Assets.at("/img/icon_Forgot_Password.png")),format.raw/*30.70*/(""""> <b>Forgot Password?</b>
								</p>
								<span>Reset your password...</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
""")))}))
      }
    }
  }

  def render(signupForm:Form[Application.Register],loginForm:Form[Application.Login]): play.twirl.api.HtmlFormat.Appendable = apply(signupForm,loginForm)

  def f:((Form[Application.Register],Form[Application.Login]) => play.twirl.api.HtmlFormat.Appendable) = (signupForm,loginForm) => apply(signupForm,loginForm)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:13:49 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/index.scala.html
                  HASH: e9d1b57fd90362df01e0eb9f6dc2ab379225ee41
                  MATRIX: 789->1|960->77|988->80|1006->90|1045->92|1073->94|1464->458|1479->464|1536->500|1795->732|1810->738|1866->773|2122->1002|2137->1008|2201->1051
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|45->14|45->14|45->14|53->22|53->22|53->22|61->30|61->30|61->30
                  -- GENERATED --
              */
          