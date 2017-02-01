import javax.inject._

import play.api.http.HttpFilters
import play.api.mvc.{Result, RequestHeader, Filter}
import scala.concurrent.{Future}
import scala.language.postfixOps
import akka.stream.Materializer

@Singleton class MyFilters @Inject()(mat: Materializer) extends HttpFilters {
  override val filters = Seq(TestFilter(mat))
}

object  TestFilter {
  def apply(mat: Materializer) = new TestFilter()(mat)
}

class TestFilter(implicit val mat: Materializer) extends Filter {

  implicit val ctx = play.api.libs.iteratee.Execution.trampoline

  override def apply(nextFilter: RequestHeader => Future[Result])
                    (requestHeader: RequestHeader): Future[Result] = {

    nextFilter(requestHeader)

  }
}