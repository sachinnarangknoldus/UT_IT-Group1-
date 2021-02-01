package com.knoldus.request

import org.scalatest.FlatSpec
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}

class CompanyImpl_Integration_Test extends FlatSpec {

  //Integration Test

    val companyName = new CompanyReadDto
    val validateEmail = new EmailValidator
    val companyValidator = new CompanyValidator(companyName,validateEmail)

    "Company" should "not be created as it already exists in DB" in {
      val KnoldusCompany: Company = Company("Knoldus","knoldus@gmail.com", "Noida")

      val companyImpl = new CompanyImpl(companyValidator)
      val result = companyImpl.createCompany(KnoldusCompany)
      assert(result.isEmpty)
    }

    "Company" should "be created" in {
      val GoogleCompany: Company = Company("Google", "Google@gmail.com", "Hyderabad")

      val companyImpl = new CompanyImpl(companyValidator)
      val result = companyImpl.createCompany(GoogleCompany)
      assert(!result.isEmpty)
    }

  }
