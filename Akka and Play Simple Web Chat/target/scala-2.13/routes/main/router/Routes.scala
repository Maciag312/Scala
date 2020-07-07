// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bartekmaciag/Downloads/play-samples-play-scala-starter-example 2/conf/routes
// @DATE:Tue Jul 07 18:08:37 CEST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:10
  Assets_0: controllers.Assets,
  // @LINE:12
  WebChatController_1: controllers.WebChatController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:10
    Assets_0: controllers.Assets,
    // @LINE:12
    WebChatController_1: controllers.WebChatController
  ) = this(errorHandler, Assets_0, WebChatController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_0, WebChatController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix, """controllers.WebChatController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chatSocket""", """controllers.WebChatController.socket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """name""", """controllers.WebChatController.getNumberOfPeople"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:10
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_WebChatController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_WebChatController_index1_invoker = createInvoker(
    WebChatController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebChatController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_WebChatController_socket2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chatSocket")))
  )
  private[this] lazy val controllers_WebChatController_socket2_invoker = createInvoker(
    WebChatController_1.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebChatController",
      "socket",
      Nil,
      "GET",
      this.prefix + """chatSocket""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_WebChatController_getNumberOfPeople3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("name")))
  )
  private[this] lazy val controllers_WebChatController_getNumberOfPeople3_invoker = createInvoker(
    WebChatController_1.getNumberOfPeople,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebChatController",
      "getNumberOfPeople",
      Nil,
      "GET",
      this.prefix + """name""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:10
    case controllers_Assets_versioned0_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned0_invoker.call(Assets_0.versioned(file))
      }
  
    // @LINE:12
    case controllers_WebChatController_index1_route(params@_) =>
      call { 
        controllers_WebChatController_index1_invoker.call(WebChatController_1.index)
      }
  
    // @LINE:13
    case controllers_WebChatController_socket2_route(params@_) =>
      call { 
        controllers_WebChatController_socket2_invoker.call(WebChatController_1.socket)
      }
  
    // @LINE:16
    case controllers_WebChatController_getNumberOfPeople3_route(params@_) =>
      call { 
        controllers_WebChatController_getNumberOfPeople3_invoker.call(WebChatController_1.getNumberOfPeople)
      }
  }
}
