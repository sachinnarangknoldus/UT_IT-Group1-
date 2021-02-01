package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company

class CompanyValidator (companyRead:CompanyReadDto,emailValidator:EmailValidator) {

  def companyIsValid(company: Company): Boolean = {

    val CInfo:Option[Company]= companyRead.getCompanyByName(company.name)
    val isEmailValid= emailValidator.emailIdIsValid(company.emailId) 

    if(CInfo.isEmpty && isEmailValid)
      true
    else
      false

  }

}
