import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp{
  override def run(args: List[String]): IO[ExitCode] = {
    val greeter: Greeter = new Greeter(new OneNameRepository())

    for {
      greeting <- greeter.hello
      _ <- IO.println(greeting)
    } yield ExitCode.Success
  }
}
