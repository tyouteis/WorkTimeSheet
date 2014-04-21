import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import org.specs2.specification.{ BeforeExample, AfterExample, Scope }

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification with BeforeExample {
  def fakeApp = FakeApplication(
    additionalConfiguration = inMemoryDatabase())

  def before = {
    running(fakeApp) {
       1 must beEqualTo(1)
    }
  }

  "Application" should {

    "work from within a browser" in new WithBrowser {
      running(fakeApp) {
        //browser.goTo("http://localhost:" + port + "/assets/javascripts/jquery-1.9.0.min.js")
        browser.goTo("http://localhost:" + port + "/tasks")
        //println(browser.pageSource)
        browser.pageSource must contain("task(s)")
     }
    }
  }
}
