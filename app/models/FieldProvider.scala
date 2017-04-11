package models

import play.api.db._
import anorm._
import anorm.SqlParser._
import com.google.inject.Inject
/**
  * Created by robert on 07.01.2017.
  */
case class Field(
                      idField: Int,
                      idDocument: Int,
                      name: String,
                      dataType: String,
                      constraint: Constraint
                    )

class FieldProvider(db:Database) {

  val mapFields = getAll.groupBy(_.idDocument)

  def getFields(idDocument:Int) = mapFields.get(idDocument)

  val simple = {
    get[Int]("idField") ~
    get[Int]("idDocument") ~
      get[String]("name") ~
      get[String]("dataType") ~
      get[String]("constraint") map {
      case idField~idDocument ~ name ~ dataType ~ constraint =>
        Field(idField, idDocument, name, dataType, new Constraint(constraint))
    }
  }

  def getAll : List[Field] = {
    db.withConnection { implicit conn =>
      SQL"""
    SELECT
       idField,
       idDocument,
       name,
       dataType,
       constraint
    FROM Fields;
  """.as(simple *)
    }

  }
}
