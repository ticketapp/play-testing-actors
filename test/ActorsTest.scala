import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}
import play.api.Mode
import play.api.inject.guice.GuiceApplicationBuilder

class ActorsTest
  extends TestKit(ActorSystem("testActorSystem"))
    with WordSpecLike with MustMatchers with BeforeAndAfterAll with ImplicitSender {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  val actorBProbe = TestProbe()
  lazy val appBuilder = new GuiceApplicationBuilder().in(Mode.Test)
  lazy val injector = appBuilder.injector()
  lazy val factory = injector.instanceOf[ActorA.Factory]
  lazy val ec = scala.concurrent.ExecutionContext.Implicits.global
  lazy val factoryProps = Props(factory(ec, actorBProbe.ref))
  val ActorARef = TestActorRef[ActorA](factoryProps)

  "Actor B" must {

    "received a message from actor A" in {
      ActorARef ! 5L

      actorBProbe.expectMsg(6L)
    }
  }
}
