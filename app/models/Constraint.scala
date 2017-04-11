package models

/**
  * Created by robert on 29.01.2017.
  */
class Constraint(strConstraint:String) {
  val isMandatory = strConstraint.split(",").contains("NN")
}
