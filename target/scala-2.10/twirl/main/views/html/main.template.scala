
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[User,Html,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User = null, scripts: Html = Html(""), currentEmail: String=controllers.helpers.AccessMiddleware.getSessionEmail())(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.139*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
		<title>Dan's Rookie Cards | Your One-Stop-Shop for your Baseball Card Needs!</title>
  		<link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.55*/routes/*8.61*/.Assets.at("img/favicon.ico")),format.raw/*8.90*/("""">
  	  	
  		<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500italic,700,500,700italic,900,900italic' rel='stylesheet' type='text/css'>
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

		<link rel="stylesheet" href=""""),_display_(/*13.33*/routes/*13.39*/.Assets.at("css/app.css")),format.raw/*13.64*/("""">
		<link href=""""),_display_(/*14.16*/routes/*14.22*/.Assets.at("css/bootstrap/bootstrap.min.css")),format.raw/*14.67*/("""" rel="stylesheet" type="text/css" />
		<link href=""""),_display_(/*15.16*/routes/*15.22*/.Assets.at("css/style.css")),format.raw/*15.49*/("""" rel="stylesheet" type="text/css" />
		<link href=""""),_display_(/*16.16*/routes/*16.22*/.Assets.at("css/formoid/formoid-solid-dark.css")),format.raw/*16.70*/("""" rel="stylesheet" type="text/css" />
         
	    <script data-main=""""),_display_(/*18.26*/routes/*18.32*/.Assets.at("js/main.js")),format.raw/*18.56*/("""" src=""""),_display_(/*18.64*/routes/*18.70*/.Assets.at("lib/requirejs/require.js")),format.raw/*18.108*/(""""></script>
	    <script src=""""),_display_(/*19.20*/routes/*19.26*/.Assets.at("lib/angularjs/angular.js")),format.raw/*19.64*/("""" type="text/javascript"></script>
	   	<script src=""""),_display_(/*20.20*/routes/*20.26*/.Assets.at("js/jquery/jquery.min.js")),format.raw/*20.63*/("""" type="text/javascript"></script>
	   	<script src=""""),_display_(/*21.20*/routes/*21.26*/.Assets.at("js/bootstrap/bootstrap.js")),format.raw/*21.65*/("""" type="text/javascript"></script>
	    <script src=""""),_display_(/*22.20*/routes/*22.26*/.Assets.at("js/password.js")),format.raw/*22.54*/("""" type="text/javascript"></script>
		<script src=""""),_display_(/*23.17*/routes/*23.23*/.Assets.at("js/jquery/jquery.prettyPhoto.js")),format.raw/*23.68*/("""" type="text/javascript"></script>
		<script src=""""),_display_(/*24.17*/routes/*24.23*/.Assets.at("js/jquery/jquery.nicescroll.min.js")),format.raw/*24.71*/("""" type="text/javascript"></script>
		<script src=""""),_display_(/*25.17*/routes/*25.23*/.Assets.at("js/jquery/jquery.flexslider-min.js")),format.raw/*25.71*/("""" type="text/javascript"></script>
		<script src=""""),_display_(/*26.17*/routes/*26.23*/.Assets.at("js/animate.js")),format.raw/*26.50*/("""" type="text/javascript"></script>
		<script src=""""),_display_(/*27.17*/routes/*27.23*/.Assets.at("js/jquery/jquery.BlackAndWhite.js")),format.raw/*27.70*/(""""></script>
		<script src=""""),_display_(/*28.17*/routes/*28.23*/.Assets.at("js/myscript.js")),format.raw/*28.51*/("""" type="text/javascript"></script>
		<script src=""""),_display_(/*29.17*/routes/*29.23*/.Assets.at("js/global.js")),format.raw/*29.49*/("""" type="text/javascript"></script>
		
		<script src=""""),_display_(/*31.17*/routes/*31.23*/.Assets.at("js/workflowGlobal.js")),format.raw/*31.57*/("""" type="text/javascript"></script>
		
	    <script>
			//PrettyPhoto
			jQuery(document).ready(function() """),format.raw/*35.38*/("""{"""),format.raw/*35.39*/("""
				"""),format.raw/*36.5*/("""$("a[rel^='prettyPhoto']").prettyPhoto();
			"""),format.raw/*37.4*/("""}"""),format.raw/*37.5*/(""");
	
			//BlackAndWhite
			$(window).load(function() """),format.raw/*40.30*/("""{"""),format.raw/*40.31*/("""
				"""),format.raw/*41.5*/("""$('.client_img').BlackAndWhite("""),format.raw/*41.36*/("""{"""),format.raw/*41.37*/("""
					"""),format.raw/*42.6*/("""hoverEffect : true, // default true
					// set the path to BnWWorker.js for a superfast implementation
					webworkerPath : false,
					// for the images with a fluid width and height
					responsive : true,
					// to invert the hover effect
					invertHoverEffect : false,
					// this option works only on the modern browsers ( on IE lower than 9 it remains always 1)
					intensity : 1,
					speed : """),format.raw/*51.14*/("""{"""),format.raw/*51.15*/(""" """),format.raw/*51.16*/("""//this property could also be just speed: value for both fadeIn and fadeOut
						fadeIn : 300, // 200ms for fadeIn animations
						fadeOut : 300
					// 800ms for fadeOut animations
					"""),format.raw/*55.6*/("""}"""),format.raw/*55.7*/(""",
					onImageReady : function(img) """),format.raw/*56.35*/("""{"""),format.raw/*56.36*/("""
						"""),format.raw/*57.7*/("""// this callback gets executed anytime an image is converted
					"""),format.raw/*58.6*/("""}"""),format.raw/*58.7*/("""
				"""),format.raw/*59.5*/("""}"""),format.raw/*59.6*/(""");
			"""),format.raw/*60.4*/("""}"""),format.raw/*60.5*/(""");
	
			document.getElementById("searchText").addEventListener("keyup", function(event) """),format.raw/*62.84*/("""{"""),format.raw/*62.85*/("""
		    	"""),format.raw/*63.8*/("""event.preventDefault();
			    if (event.keyCode == 13) """),format.raw/*64.33*/("""{"""),format.raw/*64.34*/("""
			        """),format.raw/*65.12*/("""document.getElementById("searchTextButton").click();
			    """),format.raw/*66.8*/("""}"""),format.raw/*66.9*/("""
			"""),format.raw/*67.4*/("""}"""),format.raw/*67.5*/(""");
		</script>   
    </head>
<body>
	<img id="preloader" src=""""),_display_(/*71.28*/routes/*71.34*/.Assets.at("img/preloader.gif")),format.raw/*71.65*/("""" alt="" />
	<div class="preloader_hide">
		<div id="page">
			<header>
				<div class="menu_block">
					<div class="container clearfix">						
					<div class="row vertical-align">
							<div class="col-md-3 logo pull-left">
								<a href="/"><img src=""""),_display_(/*79.32*/routes/*79.38*/.Assets.at("img/website/baseball_header_icon_80px.png")),format.raw/*79.93*/(""""></a>
							</div>
							<div class="col-md-4">
								"""),_display_(/*82.10*/if(Option(currentEmail).forall(_.isEmpty))/*82.52*/ {_display_(Seq[Any](format.raw/*82.54*/("""
								""")))}/*83.11*/else/*83.16*/{_display_(Seq[Any](format.raw/*83.17*/("""
									"""),format.raw/*84.10*/("""<span class="singleField">
										<input class="medium" type="text" id="searchText" name="searchText" placeholder="Search Cards..." onkeydown="if (event.keyCode == 13) searchProjects();" />
										<span><a href="javascript:searchCards();"><img src=""""),_display_(/*86.64*/routes/*86.70*/.Assets.at("img/icon_Search_Main.png")),format.raw/*86.108*/(""""></a></span>
									</span>
								""")))}),format.raw/*88.10*/("""
							"""),format.raw/*89.8*/("""</div>
							<div class="col-md-5 pull-right">
								<nav class="navmenu center">
									<ul>
										<li class="scroll_btn"><a href="/">Home</a></li>
										<li class="scroll_btn"><a href="/contact">Contact</a></li>
										"""),_display_(/*95.12*/if(Option(currentEmail).forall(_.isEmpty))/*95.54*/ {_display_(Seq[Any](format.raw/*95.56*/("""
											"""),format.raw/*96.12*/("""<li class="scroll_btn"><a href="/auth">Login</a></li>
										""")))}/*97.13*/else/*97.18*/{_display_(Seq[Any](format.raw/*97.19*/("""
											"""),format.raw/*98.12*/("""<li class="scroll_btn"><a href="/logout">Logout</a></li>
											<li class="scroll_btn"><a href="/useraccount?email="""),_display_(/*99.64*/currentEmail),format.raw/*99.76*/("""" style="text-transform: lowercase;">"""),_display_(/*99.114*/currentEmail),format.raw/*99.126*/("""</a></li>
										""")))}),format.raw/*100.12*/("""
									"""),format.raw/*101.10*/("""</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</header>
			<section id="home" class="padbot0">
				<div class="mainBlock">
					<div class="container" data-appear-top-offset="-200"
						data-animated="fadeInUp">
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade in active clearfix" id="tab1">
								<p class="title">
									<b>Dan's Rookie Cards</b>
								</p>
								<span>Your One-Stop-Shop for your Baseball Card Needs!</span>
							</div>

						</div>
					</div>
				</div>
			</section>
  			<!-- Used for padding and scrolling -->
			<section id="blankMain">
				<!-- BLANK -->
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			
  			<div>"""),_display_(/*130.12*/content),format.raw/*130.19*/("""</div>
  
  			<!-- Used for padding and scrolling -->
			<section id="blank1">
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			<section id="blank2">
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			<section id="blank3">
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			<section id="blank4">
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			<section id="blank5">
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			<section id="blank6">
				<div class="services_block padbot40" data-appear-top-offset="-200"></div>
			</section>
			<footer>
				<div class="container">
					<div class="row">
						<div class="col-sm-12 text-center">
							<div class="agencyLine">Dan's Rookie Cards</div>
							<div class="linkBack">
								<a href="https://icons8.com" target="_blank">Icon pack by Icons8</a>
								&nbsp;||&nbsp;
								<a href="http://formoid.com/" target="_blank">Forms by Formoid</a>
							</div>
						</div>						
					</div>
				</div>
			</footer>
		</div>
	</div>
    </body>
	<!-- Modal for Adding Comments -->
	<div id="modalComments" class="modal fade" style="z-index: 9999;" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Comments</h4>
				</div>
				<div class="modal-body">
					<link href=""""),_display_(/*177.19*/routes/*177.25*/.Assets.at("css/formoid/formoid-solid-dark.css")),format.raw/*177.73*/("""" rel="stylesheet" type="text/css" />
					<div class="commentTextArea">
						<label class="title"><span class="required">*</span>Enter your comments:</label>
						<div class="item-cont"><textarea class="medium" name="comments" id="comments" cols="20" rows="5" required="required" placeholder="Enter your comments..."></textarea><span class="icon-place"></span></div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="container">
						<div class="row">
							<div class="col-sm-4">
							</div>
							<div class="col-sm-4">
								<div><a href="javascript:addComments();" class="buttonCustomView" style="color: #FFFFFF;">Add Comment</a></div>
							</div>
							<div class="col-sm-4">
								<button type="button" class="buttonCustomView" style="color: #FFFFFF;" data-dismiss="modal">Cancel</button>
							</div>
						</div>
					</div>
					<script type="text/javascript">
						function addComments() """),format.raw/*197.30*/("""{"""),format.raw/*197.31*/("""
							"""),format.raw/*198.8*/("""console.log("Add Comment");
							var e;
							var fieldValue1;
							var fieldValue2;
							e = document.getElementById("uniquekey");
							fieldValue1 = e.value;
							console.log("unique key = " + fieldValue1);
							e = document.getElementById("comments");
							fieldValue2 = e.value;
							console.log("comments = " + fieldValue2);
							window.location.href = "/addcomments?uniquekey=" + fieldValue1 + "&comment=" + fieldValue2;
						"""),format.raw/*209.7*/("""}"""),format.raw/*209.8*/("""
					"""),format.raw/*210.6*/("""</script>
				</div>
			</div>
		</div>
	</div>
</html>
"""))
      }
    }
  }

  def render(user:User,scripts:Html,currentEmail:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(user,scripts,currentEmail)(content)

  def f:((User,Html,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (user,scripts,currentEmail) => (content) => apply(user,scripts,currentEmail)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Mon Mar 27 14:12:29 MDT 2017
                  SOURCE: C:/WebDev/workspace/Workflow/app/views/main.scala.html
                  HASH: 5d6a1b297df2c7174867c4e4c6305554876c2504
                  MATRIX: 758->1|991->138|1021->142|1228->323|1242->329|1291->358|1651->691|1666->697|1712->722|1758->741|1773->747|1839->792|1920->846|1935->852|1983->879|2064->933|2079->939|2148->987|2250->1062|2265->1068|2310->1092|2345->1100|2360->1106|2420->1144|2479->1176|2494->1182|2553->1220|2635->1275|2650->1281|2708->1318|2790->1373|2805->1379|2865->1418|2947->1473|2962->1479|3011->1507|3090->1559|3105->1565|3171->1610|3250->1662|3265->1668|3334->1716|3413->1768|3428->1774|3497->1822|3576->1874|3591->1880|3639->1907|3718->1959|3733->1965|3801->2012|3857->2041|3872->2047|3921->2075|4000->2127|4015->2133|4062->2159|4145->2215|4160->2221|4215->2255|4353->2365|4382->2366|4415->2372|4488->2418|4516->2419|4600->2475|4629->2476|4662->2482|4721->2513|4750->2514|4784->2521|5226->2935|5255->2936|5284->2937|5504->3130|5532->3131|5597->3168|5626->3169|5661->3177|5755->3244|5783->3245|5816->3251|5844->3252|5878->3259|5906->3260|6024->3350|6053->3351|6089->3360|6174->3417|6203->3418|6244->3431|6332->3492|6360->3493|6392->3498|6420->3499|6515->3567|6530->3573|6582->3604|6876->3871|6891->3877|6967->3932|7057->3995|7108->4037|7148->4039|7178->4051|7191->4056|7230->4057|7269->4068|7554->4326|7569->4332|7629->4370|7702->4412|7738->4421|8009->4665|8060->4707|8100->4709|8141->4722|8226->4789|8239->4794|8278->4795|8319->4808|8467->4929|8500->4941|8566->4979|8600->4991|8654->5013|8694->5024|9514->5816|9543->5823|11232->7484|11248->7490|11318->7538|12303->8494|12333->8495|12370->8504|12861->8967|12890->8968|12925->8975
                  LINES: 27->1|32->1|34->3|39->8|39->8|39->8|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|47->16|47->16|47->16|49->18|49->18|49->18|49->18|49->18|49->18|50->19|50->19|50->19|51->20|51->20|51->20|52->21|52->21|52->21|53->22|53->22|53->22|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|57->26|58->27|58->27|58->27|59->28|59->28|59->28|60->29|60->29|60->29|62->31|62->31|62->31|66->35|66->35|67->36|68->37|68->37|71->40|71->40|72->41|72->41|72->41|73->42|82->51|82->51|82->51|86->55|86->55|87->56|87->56|88->57|89->58|89->58|90->59|90->59|91->60|91->60|93->62|93->62|94->63|95->64|95->64|96->65|97->66|97->66|98->67|98->67|102->71|102->71|102->71|110->79|110->79|110->79|113->82|113->82|113->82|114->83|114->83|114->83|115->84|117->86|117->86|117->86|119->88|120->89|126->95|126->95|126->95|127->96|128->97|128->97|128->97|129->98|130->99|130->99|130->99|130->99|131->100|132->101|161->130|161->130|208->177|208->177|208->177|228->197|228->197|229->198|240->209|240->209|241->210
                  -- GENERATED --
              */
          