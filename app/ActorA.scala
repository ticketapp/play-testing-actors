import javax.inject.{Inject, Named}

import akka.actor.{Actor, ActorLogging, ActorRef}
import play.api.libs.concurrent.InjectedActorSupport

import scala.concurrent.ExecutionContext

object ActorA {
  trait Factory {
    def apply(ec: ExecutionContext, actorBRef: ActorRef): Actor
  }
}

class ActorA @Inject()(implicit val ec: ExecutionContext,
                       @Named("actor-b") actorBRef: ActorRef)
    extends Actor with ActorLogging with InjectedActorSupport {

  override def receive: Receive = {
    case i: Long =>
      log info s"received $i"
      actorBRef ! (i+1)

    case _ =>
      log error "Unhandled message"
  }
}
