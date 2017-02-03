import javax.inject._

import play.api.http.HttpFilters
import play.api.mvc._

import scala.language.postfixOps

@Singleton class MyFilters @Inject()() extends HttpFilters {
  override val filters = Seq(new TestFilter())
}

class TestFilter extends EssentialFilter {
  override def apply(next: EssentialAction): EssentialAction = EssentialAction(next)
}
