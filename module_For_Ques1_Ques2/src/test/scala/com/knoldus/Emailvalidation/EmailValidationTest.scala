package com.knoldus.Emailvalidation

import org.scalatest.FlatSpec

class EmailValidationTest extends FlatSpec {

  val testemail:EmailValidation=new EmailValidation()

  "When we give a valid email it" should " accept it" in {
    var result: Boolean = testemail.isValid("sachin.narang@knoldus.com")
    assert(result==true)
  }

  "When wrong email" should "inserted except .com/.org/.net" in {
    var result1: Boolean = testemail.isValid("sachin.narang@tssopcos")
    assert(result1==false)
  }

  "email" should "invalid with space in between" in {
    var result2: Boolean = testemail.isValid("sachin  @knoldus.com")
    assert(result2 == false)
  }

}
