package com.knoldus.request

import org.scalatest.FlatSpec

class UserImpl_Integration_Test extends FlatSpec {
  import com.knoldus.db.CompanyReadDto
  import com.knoldus.models.User
  import com.knoldus.validator.{EmailValidator, UserValidator}

    val companyName = new CompanyReadDto
    val validateEmail = new EmailValidator
    val userValidator = new UserValidator(companyName,validateEmail)

    val userImpl = new UserImpl(userValidator)

    //Integration Test

    "User" should "not be created as company does not exists in DB" in {
      val User_1: User = User("Sachin","Narang",22,"sachin.narang@gmail.com","Persistence")

      val result = userImpl.createUser(User_1)
      assert(result.isEmpty)
    }

    "User" should "be created as email id is valid and company exist in DB" in {
      val User_2: User = User("shivam","nagpal",32,"shivam.nagpal@knoldus.com","Knoldus")

      val result = userImpl.createUser(User_2)
      assert(!result.isEmpty)
    }

}
