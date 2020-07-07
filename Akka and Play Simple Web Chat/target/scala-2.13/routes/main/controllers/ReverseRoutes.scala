// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bartekmaciag/Downloads/play-samples-play-scala-starter-example 2/conf/routes
// @DATE:Tue Jul 07 18:08:37 CEST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:10
package controllers {

  // @LINE:12
  class ReverseWebChatController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getNumberOfPeople(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "name")
    }
  
    // @LINE:13
    def socket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chatSocket")
    }
  
    // @LINE:12
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
