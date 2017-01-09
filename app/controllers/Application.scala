package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index(page:String,page2:Any) = Action {
    Ok("Your new application is ready.!!" + page)

  }

  def index = Action {
    Ok("Your new application is ready.!!")

  }

}