
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/WebDev/workspace/Workflow/conf/routes
// @DATE:Mon Mar 27 14:12:29 MDT 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:112
package controllers.workflow {

  // @LINE:112
  class ReverseApplicationProfile(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:123
    def openProfile(recordkey:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "wkflwopenprofile/" + implicitly[PathBindable[String]].unbind("recordkey", dynamicString(recordkey)))
    }
  
    // @LINE:119
    def initializeRecordUniqueKeys(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "wkflwinitkeys")
    }
  
    // @LINE:124
    def updateProfile(recordkey:String): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "wkflwopenprofile/" + implicitly[PathBindable[String]].unbind("recordkey", dynamicString(recordkey)))
    }
  
    // @LINE:112
    def addProfile(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "wkflwaddprofile")
    }
  
    // @LINE:115
    def viewProfiles(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "wkflwviewprofiles")
    }
  
    // @LINE:113
    def saveProfile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "wkflwaddprofile")
    }
  
    // @LINE:117
    def accessDenied(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "wkflwaccessdenied")
    }
  
    // @LINE:121
    def filterView(_pf_escape_type:String, value:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "wkflwfilterview" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("type", _pf_escape_type)), Some(implicitly[QueryStringBindable[String]].unbind("value", value)))))
    }
  
  }


}
