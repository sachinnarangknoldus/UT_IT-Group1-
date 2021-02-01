package com.knoldus.request

import org.mockito.MockitoSugar.{mock, when}
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

import org.scalatest.FlatSpec

class CompanyImplTest extends FlatSpec {

    val mockedCompanyValidator = mock[CompanyValidator]
    val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val MicrosoftCompany:Company=Company("Microsoft","Microsoft@gmail.com","Delhi")
    val companyImpl = new CompanyImpl(mockedCompanyValidator)

    //Unit Testing of class


    "Company" should " not be created" in {

      when(mockedCompanyValidator.companyIsValid(company)) thenReturn (false)
      val result = companyImpl.createCompany(company)
      assert(result.isEmpty)
    }
    "NewCompany" should "  be created" in {

      when(mockedCompanyValidator.companyIsValid(MicrosoftCompany)) thenReturn (true)
      val result = companyImpl.createCompany(MicrosoftCompany)
      assert(!result.isEmpty)
    }

}
