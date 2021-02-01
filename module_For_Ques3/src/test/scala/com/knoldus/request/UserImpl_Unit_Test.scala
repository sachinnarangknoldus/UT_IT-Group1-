package com.knoldus.request

import org.scalatest.FlatSpec
import com.knoldus.models.{Company, User}
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

class UserImpl_Unit_Test extends FlatSpec {
  val mockedUserValidate = mock[UserValidator]
  val user1: User = User("Sachin","Narang",22,"sachin.narang@knoldus.com","Knoldus")
  val newuser2: User = User("Shivam","Nagpal",23,"shivamnagpal@gmail.com","Google")
  val userImpl = new UserImpl(mockedUserValidate)

  //Unit Testing

  "User" should "be created" in {

    when(mockedUserValidate.userIsValid(newuser2)) thenReturn(true)
    val result = userImpl.createUser(newuser2)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {

    when(mockedUserValidate.userIsValid(user1)) thenReturn(false)
    val result = userImpl.createUser(user1)
    assert(result.isEmpty)
  }

}
