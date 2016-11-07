import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport
import net.codingwell.scalaguice.ScalaModule

class AllModules extends AbstractModule with AkkaGuiceSupport with ScalaModule {

  override def configure() = {
    bindActorFactory[ActorA, ActorA.Factory]
    bindActor[ActorB]("actor-b")
  }
}
