package controllers

import models.{Documents, Fields}
import play.api.libs.json.JsValue
import play.api.mvc._
import Documents.getDocumentId
import Fields.getFields

/**
 * Created by robert on 07.01.2017.
 */
class Data extends Controller {

  def save(company: String, team: String, document: String) = Action(parse.json) {
    request =>
      {
        val optIdDocument = getDocumentId(company, team, document)
        val optFields = optIdDocument.flatMap(getFields)

        optFields match{
          case Some(fields) =>
            fields.forall(field => (request.body \ field.name).toOption.isDefined) match{
              case true=> Ok("")
              case _=> BadRequest("not all fields set")
            }
          case None => BadRequest("document not found")
        }
      }
  }
}
