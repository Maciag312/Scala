import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object User {
  var id: Int = 0  // Consumer ID generator
  case class Video(v: String) // Message delivering produced item
  case class Tell(message: String)
  def props() =
  {
    id += 1
    Props(classOf[User], id - 1)
  } // props method for class with multiple-argument constructor
}

class User(private val id: Int) extends Actor {
  override def receive: Receive = {
    case User.Video(v) => {
      println(s"User $id received video $v")
    }
    case User.Tell(m) => {
      println("User " + id + m)
    }
  }
}

object Channel{
  private var id: Int = 0
  case class Video(title: String)  // Call for next item
  case class Subscribe(user: ActorRef)
  case class Unsubscribe(user: ActorRef)
  def props() = {
    id += 1
    Props(classOf[Channel], id-1)
  }
}

class Channel(private val id: Int) extends Actor {
  private var subscribers = List[ActorRef]()

  override def receive: Receive = {
    case Channel.Video(title) => {
        println("Channel "+id+ s" sending $title video to subscribers")
        subscribers.foreach(subscriber => { subscriber ! User.Video(title)})
    }
    case Channel.Subscribe(user) => {
      subscribers = user::subscribers
      user ! User.Tell(" has subscribed channel " + id)


    }
    case Channel.Unsubscribe(user) => {
      subscribers = subscribers.filter(u => !u.equals(u))
      user ! User.Tell(" has unsubscribed channel " + id)

    }
  }
}

object Main {
  val actSys = ActorSystem()
  val CinemaChannel = actSys.actorOf(Channel.props)
  val AnimalPlanet = actSys.actorOf(Channel.props)
  val HBO = actSys.actorOf(Channel.props)

  val userMoviesAndAnimals = actSys.actorOf(User.props())
  val userAnimals = actSys.actorOf(User.props())
  val userHBOAndMovies = actSys.actorOf(User.props())
  val newUser = actSys.actorOf(User.props())

  def main(args: Array[String]): Unit =
  {
    CinemaChannel ! Channel.Subscribe(userMoviesAndAnimals);
    AnimalPlanet ! Channel.Subscribe(userAnimals)
    AnimalPlanet ! Channel.Subscribe(userMoviesAndAnimals);
    Thread.sleep(1000)

    AnimalPlanet ! Channel.Video("Tigers starving in Africa");
    Thread.sleep(1000)

    AnimalPlanet ! Channel.Video("Population of rhinoceros");
    Thread.sleep(1000)

    CinemaChannel ! Channel.Video("Lord of the rings");
    Thread.sleep(1000)

    CinemaChannel ! Channel.Video("12 angry men");
    Thread.sleep(2500)
    CinemaChannel ! Channel.Subscribe(userMoviesAndAnimals);
    Thread.sleep(1000)

    CinemaChannel ! Channel.Video("American Psycho");
    Thread.sleep(1000)



    HBO ! Channel.Subscribe(userHBOAndMovies)
    HBO ! Channel.Video("Skyline")
    Thread.sleep(2500)
    HBO ! Channel.Unsubscribe(userHBOAndMovies)
    Thread.sleep(4000)
    HBO ! Channel.Video("Watchmen")
    Thread.sleep(1000)

    HBO ! Channel.Subscribe(newUser)
    Thread.sleep(1000)

    HBO ! Channel.Video("Bad banks")
// /27,75+9+L2+10
//
//    channel.tell(Channel.NextItem, user0)  // Operator "!" is alias for "tell" method.
//    channel.tell(Channel.NextItem, user1)  // "tell" method allows us to specify message and sender.
    // In this case producer will think that both messages were sent by consumers
  }
}
