package com.knoldus.db

import org.scalatest.FlatSpec

class UserReadDtoTest extends FlatSpec {

  "User Sachin" should "exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Sachin")
    assert(!result.isEmpty)
  }

  "User Rishab" should "not exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Rishab")
    assert(result.isEmpty)
  }

  "User Shashank" should "exist" in {
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Shashank")
    assert(!result.isEmpty)
  }

}
