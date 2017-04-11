package models

import javax.inject.Inject

import play.api.db._
import anorm._
import anorm.SqlParser._
import com.google.inject.Singleton
/**
  * Created by robert on 07.01.2017.
  */

@Singleton
class DocumentProvider @Inject()(db: Database){
  val mapDocuments = getAll.map(d => (d.company, d.team, d.name) -> d.idDocument).toMap

  def getDocumentId(company: String, team: String, name: String) = mapDocuments.get(company, team, name)

  val simple = {
    get[Int]("idDocument") ~
      get[String]("company") ~
      get[String]("team") ~
      get[String]("name") map {
      case idDocument ~ company ~ team ~ name =>
        Document(idDocument, company, team, name)
    }
  }

  def getAll: List[Document] = {
    db.withConnection { implicit conn =>
      SQL"""
    SELECT
       idDocument,
       company,
       team,
       name
    FROM Document;
  """.as(simple *)
    }

  }
}