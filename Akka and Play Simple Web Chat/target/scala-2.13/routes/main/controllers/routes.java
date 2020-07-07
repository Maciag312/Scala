// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bartekmaciag/Downloads/play-samples-play-scala-starter-example 2/conf/routes
// @DATE:Tue Jul 07 18:08:37 CEST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseWebChatController WebChatController = new controllers.ReverseWebChatController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseWebChatController WebChatController = new controllers.javascript.ReverseWebChatController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
