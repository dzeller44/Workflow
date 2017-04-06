
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/WebDev/workspace/Workflow/conf/routes
// @DATE:Mon Mar 27 14:12:29 MDT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:112
package controllers.workflow.javascript {
  import ReverseRouteContext.empty

  // @LINE:112
  class ReverseApplicationProfile(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:123
    def openProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.openProfile",
      """
        function(recordkey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwopenprofile/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("recordkey", encodeURIComponent(recordkey0))})
        }
      """
    )
  
    // @LINE:119
    def initializeRecordUniqueKeys: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.initializeRecordUniqueKeys",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwinitkeys"})
        }
      """
    )
  
    // @LINE:124
    def updateProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.updateProfile",
      """
        function(recordkey0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwopenprofile/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("recordkey", encodeURIComponent(recordkey0))})
        }
      """
    )
  
    // @LINE:112
    def addProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.addProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwaddprofile"})
        }
      """
    )
  
    // @LINE:115
    def viewProfiles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.viewProfiles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwviewprofiles"})
        }
      """
    )
  
    // @LINE:113
    def saveProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.saveProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwaddprofile"})
        }
      """
    )
  
    // @LINE:117
    def accessDenied: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.accessDenied",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwaccessdenied"})
        }
      """
    )
  
    // @LINE:121
    def filterView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.workflow.ApplicationProfile.filterView",
      """
        function(type0,value1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wkflwfilterview" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("type", type0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("value", value1)])})
        }
      """
    )
  
  }


}
