package models

import com.google.common.reflect.TypeToken
import play.api.libs.json.JsValue
import play.api.mvc._

import scala.collection.immutable.HashMap
import com.fasterxml.jackson.databind.ObjectMapper

/**
  * Created by robert on 29.01.2017.
  */
object ValidateDocument {
  def jsonMap(json:String) = {


    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val obj = mapper.readValue[Map[String, Object]](jsonString)
  }
  def apply(fields:List[Field],body:JsValue) ={
    Map<String, Object> retMap = new Gson().fromJson(
      body.toString(), new TypeToken<HashMap<String, Object>>() {}.getType()
    );
     mandatory(fields,body)
  }

  def mandatory(fields:List[Field],body:JsValue) = {
    fields.filter(_.constraint.isMandatory).forall(field => (body \ field.name).toOption.isDefined) match{
      case false=> Some("mandatory fields not set")
      case _=> None
    }
  }

  def fieldTypes(fields:List[Field],body:JsValue) = {
    val result = fields.forall(field => (body \ field.name))
  }

}
