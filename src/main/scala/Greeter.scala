import cats.effect.IO

class Greeter(nameRepository: NameRepository){

  val hello: IO[String] = IO("hello")

  def helloName(): IO[String] =
    hello.map(_ + s", ${nameRepository.getName}")
}
