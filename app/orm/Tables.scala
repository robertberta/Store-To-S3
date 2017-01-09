package orm

trait Tables extends scala.AnyRef {
  val profile : slick.driver.JdbcProfile
  val schema : Tables.this.profile.SchemaDescription = { /* compiled code */ }
  @scala.deprecated("Use .schema instead of .ddl")
  def ddl : Tables.this.profile.SchemaDescription = { /* compiled code */ }
  case class DocumentRow(val iddocument : scala.Int, val company : scala.Predef.String, val team : scala.Predef.String, val name : scala.Predef.String) extends scala.AnyRef with scala.Product with scala.Serializable {
  }
  implicit def GetResultDocumentRow(implicit e0 : slick.jdbc.GetResult[scala.Int], e1 : slick.jdbc.GetResult[scala.Predef.String]) : slick.jdbc.GetResult[Tables.this.DocumentRow] = { /* compiled code */ }
  class Document(_tableTag : Tables.this.profile.api.Tag) extends Tables.this.profile.api.Table[Tables.this.DocumentRow] {
    def * : slick.lifted.ProvenShape[Tables.this.DocumentRow] = { /* compiled code */ }
    def ? : slick.lifted.MappedProjection[scala.Option[Tables.this.DocumentRow], scala.Tuple4[scala.Option[scala.Int], scala.Option[java.lang.String], scala.Option[java.lang.String], scala.Option[java.lang.String]]] = { /* compiled code */ }
    val iddocument : Tables.this.profile.api.Rep[scala.Int] = { /* compiled code */ }
    val company : Tables.this.profile.api.Rep[scala.Predef.String] = { /* compiled code */ }
    val team : Tables.this.profile.api.Rep[scala.Predef.String] = { /* compiled code */ }
    val name : Tables.this.profile.api.Rep[scala.Predef.String] = { /* compiled code */ }
    val pk : slick.lifted.PrimaryKey = { /* compiled code */ }
    val fieldsFk : slick.lifted.ForeignKeyQuery[Tables.this.Fields, Tables.this.FieldsRow] = { /* compiled code */ }
  }
  class Fields(_tableTag : Tables.this.profile.api.Tag) extends Tables.this.profile.api.Table[Tables.this.FieldsRow] {
    def * : slick.lifted.ProvenShape[Tables.this.FieldsRow] = { /* compiled code */ }
    def ? : slick.lifted.MappedProjection[scala.Option[Tables.this.FieldsRow], scala.Tuple5[scala.Option[scala.Int], scala.Option[scala.Int], scala.Option[java.lang.String], scala.Option[java.lang.String], scala.Option[java.lang.String]]] = { /* compiled code */ }
    val idfields : Tables.this.profile.api.Rep[scala.Int] = { /* compiled code */ }
    val iddocument : Tables.this.profile.api.Rep[scala.Int] = { /* compiled code */ }
    val name : Tables.this.profile.api.Rep[scala.Predef.String] = { /* compiled code */ }
    val `type` : Tables.this.profile.api.Rep[scala.Predef.String] = { /* compiled code */ }
    val constraint : Tables.this.profile.api.Rep[scala.Predef.String] = { /* compiled code */ }
  }
  case class FieldsRow(val idfields : scala.Int, val iddocument : scala.Int, val name : scala.Predef.String, val `type` : scala.Predef.String, val constraint : scala.Predef.String) extends scala.AnyRef with scala.Product with scala.Serializable {
  }
  val Document : slick.lifted.TableQuery[Tables.this.Document] = { /* compiled code */ }
  implicit def GetResultFieldsRow(implicit e0 : slick.jdbc.GetResult[scala.Int], e1 : slick.jdbc.GetResult[scala.Predef.String]) : slick.jdbc.GetResult[Tables.this.FieldsRow] = { /* compiled code */ }
  val Fields : slick.lifted.TableQuery[Tables.this.Fields] = { /* compiled code */ }
}

object Tables extends scala.AnyRef with orm.Tables {
  val profile : slick.driver.MySQLDriver.type = { /* compiled code */ }
}