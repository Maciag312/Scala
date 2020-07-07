
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object chatPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[RequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.3*/()(implicit request: RequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
 """),_display_(/*3.3*/main("WebSocket Chat")/*3.25*/{_display_(Seq[Any](format.raw/*3.26*/("""

   """),format.raw/*5.4*/("""<h2>Welcome in real time chat</h2>
   <h3>Open new browsers to add another user to chat</h3>
   <h4 id="user-count"></h4>
        Enter your name
     <input type="text" id="chat-input" size="80"> <button>Confirm</button>
   <br>
     <input type="hidden" id="ws-route" value=""""),_display_(/*11.49*/routes/*11.55*/.WebChatController.socket.absoluteURL()),format.raw/*11.94*/("""">
     <textarea disabled id="chat-area" rows="40" cols="80"></textarea>
     <br>

   <input type="text" id="chat-input" size="80">
     <script src=""""),_display_(/*16.20*/routes/*16.26*/.Assets.versioned("javascripts/chat.js")),format.raw/*16.66*/(""""></script>


 """)))}))
      }
    }
  }

  def render(request:RequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply()(request,flash)

  def f:(() => (RequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = () => (request,flash) => apply()(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-07-07T18:20:54.392851
                  SOURCE: /Users/bartekmaciag/Downloads/play-samples-play-scala-starter-example 2/app/views/chatPage.scala.html
                  HASH: 381c6f1d5010350acbd7227d61a730c3e989935e
                  MATRIX: 745->2|888->52|916->55|946->77|984->78|1015->83|1320->361|1335->367|1395->406|1575->559|1590->565|1651->605
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|35->11|35->11|35->11|40->16|40->16|40->16
                  -- GENERATED --
              */
          