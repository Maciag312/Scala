//import akka.actor.{Actor, ActorRef, ActorSystem, Props}
//case class Hello(name: String)
//class Greeter extends Actor {
//  def receive: Receive = {
//    case Hello (name)=>println(s"Hello, $name")
//    case _=>println("Ops")
//  }
//}
//object Main {
//  def main(args: Array[String]): Unit = {
//    val actSys: ActorSystem = ActorSystem()
//    val greeter: ActorRef = actSys.actorOf(Props[Greeter])
//    greeter!Hello("Actor")
//    greeter! "Sth wierd"
//    actSys.terminate()
//  }
//}
