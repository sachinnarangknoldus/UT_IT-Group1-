package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class UserReadDto {
  val user1: User = User("Shashank","Goyal",21,"knoldus","shashank.goyal@knoldus.com")
  val user2: User = User("Sachin","Narang",22,"knoldus","sachin.narang@knoldus.com")


  val users: HashMap[String, User] = HashMap("Shashank" -> user1, "Sachin" -> user2)
  def getUserByName(name: String): Option[User] = users.get(name)
}