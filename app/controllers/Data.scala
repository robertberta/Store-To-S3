package controllers

import javax.inject.Inject

import play.api.mvc._
import models.{DocumentProvider, Field, FieldProvider, ValidateDocument}
import play.api.db.Database

/**
 * Created by robert on 07.01.2017.
 */
class Data @Inject()(db:Database) extends Controller {
  val documentProvider = new DocumentProvider(db)
  val fieldProvider = new FieldProvider(db)

  def save(company: String, team: String, document: String) = Action(parse.json) {
    request =>
      {
        val documentId:Option[Int] = documentProvider.getDocumentId(company, team, document)
        val fields:Option[List[Field]] = documentId.flatMap(fieldProvider.getFields)

        fields match{
          case Some(fields) => {
            match ValidateDocument(fields,request.body){
              case Some(error) => Bad(error)
              case None => Ok()
            }

          }
        }
        val validate = Validate(request.body,optFields)


        Validate(optFields,request.body)

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
