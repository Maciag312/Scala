
object Main extends App {
  println("Hello, World!");
  val dollworkshop = new Workshop[Doll]
  val car = new Car
  dollworkshop.employ(new ElfDollMaker("blue"))
  dollworkshop.makeToys(5)
  dollworkshop.makeToys(3)
}