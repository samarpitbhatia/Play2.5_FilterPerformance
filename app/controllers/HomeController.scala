package controllers

import play.api.mvc.{Action, Controller}

class StatusController extends Controller {

  def status = Action { implicit request =>
    Ok
  }
}
