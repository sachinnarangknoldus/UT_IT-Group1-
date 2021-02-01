package com.knoldus.db

import org.scalatest.FlatSpec

class CompanyReadDtoTest extends FlatSpec {

  "Company microsoft" should " not exist because we have not created it" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Microsoft")
    assert(result.isEmpty)
  }

  "Company Knoldus" should "exist because we have created it" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  "Company Philips" should "exist because we have created it" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Philips")
    assert(!result.isEmpty)
  }
}
