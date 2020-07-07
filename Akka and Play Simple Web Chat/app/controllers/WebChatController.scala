package controllers
import java.util.concurrent.TimeUnit

import actors.ChatManagerActor.AskNameMessage
import actors.{ChatActor, ChatManagerActor}
import akka.actor.{ActorRef, ActorSystem, Props}
import akka.stream.Materializer
import akka.util.Timeout
import javax.inject.{Inject, Singleton}
import play.api.libs.streams.ActorFlow
import play.api.mvc.{AbstractController, ControllerComponents, WebSocket}
import akka.pattern.ask

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

@Singleton
class WebChatController @Inject() (cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc){
  val manage = system.actorOf(Props[ChatManagerActor],"Manager")

  def index = Action { implicit request =>
    Ok(views.html.chatPage())
  }

  def socket = WebSocket.accept[String, String]{request =>
    println("Getting Socket")

    ActorFlow.actorRef { out =>
      ChatActor.props(out, manage)
    }
  }

  def changeName(name: String) = {

  }

  def getNumberOfPeople  =  Action {

    // (1) this is one way to "ask" another actor
    implicit val timeout = Timeout(15, java.util.concurrent.TimeUnit.SECONDS)
    val future = manage ? ChatManagerActor.AskNameMessage()
    val result2 = Await.result(future, Duration.create(15, TimeUnit.SECONDS))
    Ok(result2.toString()
    )
  }


}
