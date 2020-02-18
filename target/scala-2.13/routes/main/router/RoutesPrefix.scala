// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/thomasward/code/play-samples-play-java-hello-world-tutorial/conf/routes
// @DATE:Sun Feb 16 22:21:47 MST 2020


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
