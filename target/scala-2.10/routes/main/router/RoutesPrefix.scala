
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/WebDev/workspace/Workflow/conf/routes
// @DATE:Mon Mar 27 14:12:29 MDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
