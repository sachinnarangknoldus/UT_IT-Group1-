package com.knoldus.validator

import org.scalatest.FlatSpec

class EmailValidatorTest extends FlatSpec {
    val emailValidator = new EmailValidator
    "email" should "have alphanumeric recipient name in lowercase and/or uppercase " in {
      var result: Boolean = emailValidator.emailIdIsValid("sachin.narang@knoldus.com")
      assert(result == true)
    }

    "email" should "valid when recipient name has dot and hiphen('-')" in {
      var result: Boolean = emailValidator.emailIdIsValid("1902.sachin-narang@knoldus.com")
      assert(result == true)
    }
  "email" should "invalid with missing main domain" in {
    var result: Boolean = emailValidator.emailIdIsValid("sachin@.com")
    assert(result == false)
  }

}
