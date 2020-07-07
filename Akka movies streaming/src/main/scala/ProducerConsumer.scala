import akka.actor.{Actor, ActorRef, ActorSystem, Props}


class Producer extends Actor {
  private var items = List[Int](1,2,3,4,5)

  override def receive: Receive =
  {
    case Producer.NextItem => items match {
      case h::t => {
                      println(s"Producing value $h")
                      items = t
                      sender ! Consumer.Item(h)
                   }
      case Nil => {
                    println("No more items")
                    sender ! Consumer.NoItem
                  }
    }
  }
}

object Producer {
  case object NextItem  // Call for next item
  def props = Props[Producer]  // props method for zero argument constructor class
}

class Consumer(private val id: Int, private val producer: ActorRef) extends Actor {
  override def receive: Receive =
  {
    case Consumer.NoItem => {
                              println(s"No items left for consumer $id - ending")
                              context.system.terminate          // It kills the ActorSystem
                            }
    case Consumer.Item(v) => {
                               println(s"Consumer $id received item $v")
                               sender ! Producer.NextItem
                             }
  }
}

object Consumer {
  private var id: Int = 0  // Consumer ID generator

  case class Item(v: Int) // Message delivering produced item
  case object NoItem      // Message indicating that there are no more items left

  def props(producer: ActorRef) =
  {
    id += 1
    Props(classOf[Consumer], id - 1, producer)
  } // props method for class with multiple-argument constructor
}

object MainProducerConsumer {
  val actSys = ActorSystem()
  val producer = actSys.actorOf(Producer.props)
  val consumer0 = actSys.actorOf(Consumer.props(producer))
  val consumer1 = actSys.actorOf(Consumer.props(producer))

  def main(args: Array[String]): Unit =
  {
     producer.tell(Producer.NextItem, consumer0)  // Operator "!" is alias for "tell" method.
     producer.tell(Producer.NextItem, consumer1)  // "tell" method allows us to specify message and sender.
                                                  // In this case producer will think that both messages were sent by consumers
  }
}