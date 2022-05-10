import cats.effect._
import cats.effect.testing.scalatest.AsyncIOSpec
import org.scalamock.scalatest.MockFactory
import org.scalatest.freespec.AsyncFreeSpecLike
import org.scalatest.matchers.should.Matchers

class Tests extends MockFactory with Matchers with AsyncFreeSpecLike with AsyncIOSpec {

  trait mocks{
    val repo = mock[NameRepository]
    val greeter = new Greeter(repo)
  }

  "My Code " - {
    "works" in {
      IO(1).asserting(_ shouldBe 1)
    }
  }

  "hello " - {
    "works" in {
      val mock = new mocks{}
      import mock._

      greeter.hello.asserting(_ shouldBe "hello")
    }
  }

  "helloName" - {
    "works" in {
      val mock = new mocks{}
      import mock._
      (repo.getName _).expects().returns("name")

      greeter.helloName().asserting{
        _ should endWith ("name")
      }
    }
  }

}
