import akka.testkit.TestActorRef
import com.akkadb.{AkkaDb, SetRequest}
import org.specs2.mutable._
import util.AkkaTestkitSpecs2Support

class AkkaDbSpec extends Specification {
  sequential

  "akkaDb given message SetRequest" should {

    "replace key/value into map" in new AkkaTestkitSpecs2Support {
      val actorRef = TestActorRef(new AkkaDb)
      val akkaDb = actorRef.underlyingActor

      actorRef ! SetRequest("key", "value")
      akkaDb.map.get("key") must be equalTo Some("value")
    }
  }
}
