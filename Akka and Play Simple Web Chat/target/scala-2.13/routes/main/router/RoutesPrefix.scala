// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bartekmaciag/Downloads/play-samples-play-scala-starter-example 2/conf/routes
// @DATE:Tue Jul 07 18:08:37 CEST 2020


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
