package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User


class UserValidator (companyName:CompanyReadDto,emailvalid:EmailValidator){
  def userIsValid(user: User): Boolean = {
    if (!companyName.getCompanyByName(user.companyName).isDefined && emailvalid.emailIdIsValid(user.emailId))
      true
    else
      false
  }
}