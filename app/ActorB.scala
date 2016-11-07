import akka.actor.{Actor, ActorLogging}

object ActorB {
  trait Factory {
    def apply(): Actor
  }
}

class ActorB extends Actor with ActorLogging {

  override def receive: Receive = {
    case _ =>
      log error "B received an unhandled message"
  }
}
