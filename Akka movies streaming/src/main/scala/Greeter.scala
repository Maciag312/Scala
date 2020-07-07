import akka.actor.{Actor, ActorRef, ActorSystem, Props}

class Greeter extends Actor {
  def receive: Receive =
  {
    case Greeter.Hello(name) => println(s"Greetings $name") // Greeter.Hello gives access to type Hello defined in
    case str: String => println(str)                                                        // the companion object.
                                                            // s" " is called s String Interpolator.
    // It substitutes $ variable names with their values.
  }
}

object Greeter {
  case class Hello(name: String) // Message type - has to be immutable, and has to allow pattern matching.
                               // That's why case classes and case objects are used as message types.

  def props: Props = Props[Greeter] // props creates Props object for Greeter actor.
                                    // In this case Greeter constructor has no arguments.
}

object MainGreeter {
  def main(args: Array[String]): Unit =
  {
    val actSys = ActorSystem()
    val greeter: ActorRef = actSys.actorOf(Greeter.props)
    val secgreeter: ActorRef = actSys.actorOf(Greeter.props)

    greeter ! Greeter.Hello("Karen")
    greeter ! Greeter.Hello("Artur")
    greeter ! "Bob" // "Bob" has type String that is not handled by the Greeter actor - there will be no message.
    secgreeter ! Greeter.Hello("Bartek")

    Thread.sleep(1000) // This sleep freezes main thread.
                              // NEVER call sleep method inside an Actor as it may reduce efficiency of the whole program
                              // and even break whole actor system. This is because an Actor can run on multiple threads
                              // or a thread can execute multiple Actors.
    actSys.terminate
  }
}