trait Toy
class Car(val colour: String) extends Toy {
  override def toString: String = colour + " car"
}
class Truck(val colour: String) extends Car {
  override def toString: String = colour + " truck"
}
class Doll(val colour: String) extends Toy {
  override def toString: String =  colour + " doll"
}
trait Elf[+A] {
  def makeToy(): A
}
class ElfCarMaker(val colour: String) extends Elf[Car] {
  override def makeToy(): Car = {
    val car = new Car(colour);
    println(car + "was made")
    car
  }
}
class ElfTruckMaker(val colour: String) extends Elf[Truck] {
  override def makeToy(): Truck = {
    val truck = new Truck(colour);
    println(truck + "  was made")
    truck;
  }
}
class ElfDollMaker(val colour: String) extends Elf[Doll] {
  override def makeToy(): Doll = {
    val doll = new Doll(colour);
    println(doll + "  was made")
    doll;
  }
}
trait ToyList[+T]
case object Empty extends ToyList[Nothing]
case class MadeToy[A](item: A, rest: ToyList[A]) extends ToyList[A]

class Workshop[T]() {
  private var employee: Option[Elf[T]] = None
  private val list: List[T] = List()
  def employ(employee: Elf[T]) {
      this.employee = Some(employee)
    }
  def makeToys(quantity: Int): List[T] = {
      def recurs(list: List[T], coutner: Int): List[T] = {
        if (coutner == 0 || employee.isEmpty) list
        else recurs(employee.get.makeToy()::list, coutner - 1)
      }
      recurs(list, quantity)
    }
}
