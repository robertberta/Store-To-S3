package controllers

import play.api.mvc._
import src.DocumentInfo

/**
 * Created by robert on 07.01.2017.
 */
class Data extends Controller {
  val documentInfo = DocumentInfo

  def save(company: String, team: String, doc: String) = Action(parse.json) {

    request =>
      {
//         documentInfo.fields(company,team,doc).forall({
//           request.body \ "name"         })
      }
      Ok()
  }
}
