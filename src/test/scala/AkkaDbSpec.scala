import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkadb.{AkkaDb, SetRequest}
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class AkkaDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach{
  implicit val system = ActorSystem()

  describe("akkaDb") {
    describe("given message SetRequest") {
      it("should replace key/value into map") {
        val actorRef = TestActorRef(new AkkaDb)
        actorRef ! SetRequest("key", "value")
        val akkaDb = actorRef.underlyingActor
        akkaDb.map.get("key") should equal(Some("value"))
      }
    }
  }
}
