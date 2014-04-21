import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

import org.specs2.specification.{ BeforeExample, AfterExample, Scope }

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification with BeforeExample {
  def fakeApp = FakeApplication(
    additionalConfiguration = inMemoryDatabase())
  def before = {
    running(fakeApp) {
       1 must beEqualTo(1)
    }
  }

  "Application" should {

    "send 303 on a undefined action" in {
      running(fakeApp) {
        route(FakeRequest(GET, "/boum")) must beNone
      }
    }

    "render the index page" in {
      running(fakeApp) {
        val home = route(FakeRequest(GET, "/tasks")).get
        //println(contentAsString(home))
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("task(s)")
      }
    }
  }
}
