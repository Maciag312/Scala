package actors


import actors.ChatManagerActor._
import akka.actor.{Actor, ActorRef}

import scala.collection.mutable
import scala.collection.mutable._

class ChatManagerActor extends Actor{



  private var chatters = List.empty[ActorRef]
  private var conversations = mutable.Set.empty[(ActorRef,ActorRef)]



  def receive = {
    case NewChatter(chatter) => chatters ::= chatter
    case PublicMessage(msg) => for (c <- chatters) c ! ChatActor.SendMessage(msg)
    case NewConversation(conv1, conv2) => conversations += ((conv1, conv2))
    case AskNameMessage() => sender() ! chatters.size
  }

}
object ChatManagerActor {
  case class NewChatter(chatter: ActorRef)
  case class PublicMessage(msg: String)
  case class NewConversation(conv1: ActorRef, conv2: ActorRef)
  case class MessageGroup(msg: String, groupId: String)
  case class AskNameMessage()
}
