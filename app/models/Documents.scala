package models

import play.api.db._
import anorm._
import anorm.SqlParser._
/**
  * Created by robert on 07.01.2017.
  */
case class Documents(
                      idDocument: Int,
                      company: String,
                      team: String,
                      name: String
                    )

object Documents {

  val mapDocuments = getAll.map(d => (d.company, d.team, d.name) -> d.idDocument).toMap

  def getDocumentId(company: String, team: String, name: String) = mapDocuments.get(company, team, name)

  val simple = {
    get[Int]("idDocument") ~
      get[String]("company") ~
      get[String]("team") ~
      get[String]("name") map {
      case idDocument ~ company ~ team ~ name =>
        Documents(idDocument, company, team, name)
    }
  }

  def getAll: List[Documents] = {
    DB.withConnection { implicit conn =>
      SQL"""
    SELECT
       idDocument,
       company,
       team,
       name
    FROM Documents;
  """.as(simple *)
    }

  }
}