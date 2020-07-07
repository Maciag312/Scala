package actors
import java.util.Calendar

import actors.ChatActor.{SendMessage}
import akka.actor.{Actor, ActorRef, Props}

import scala.util.Random

class ChatActor(out: ActorRef, manager: ActorRef, name: String) extends Actor{
  manager ! ChatManagerActor.NewChatter(self)

  val generator = new Random(System.currentTimeMillis());

  def getTime(): String ={
    import java.time.ZonedDateTime
    import java.time.format.{DateTimeFormatter, FormatStyle}
    val zdt = ZonedDateTime.now
    DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(zdt)
  }

  val id = "user" + generator.between(1,3000)

  def changeName():
  def receive = {
    case s: String => manager ! ChatManagerActor.PublicMessage( getTime() + " " + id + ": " + s)
    case SendMessage(msg) => out ! msg;
    case m => println(" Unhanlded message in ChatActor" + m)

  }
  out ! "Connected!"
}

object ChatActor {
  def props(out:ActorRef, manager: ActorRef) = Props(new ChatActor(out, manager))
  case class SendMessage(msg: String)
}