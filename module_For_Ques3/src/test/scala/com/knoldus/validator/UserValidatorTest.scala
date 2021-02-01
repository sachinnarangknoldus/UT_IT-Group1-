package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.models.Company
import org.scalatest.FlatSpec
import org.mockito.MockitoSugar.{mock, when}

class UserValidatorTest extends FlatSpec {

  val company: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val user: User = User("Sachin", "Narang",22, "sachin.narang@knoldus.com", "knoldus")
  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  val userValidator = new UserValidator(mockedCompanyReadDto, mockedEmailValidator)

  "User" should "not be valid as his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn (Option(company))
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn (false)
    val result = userValidator.userIsValid(user)
    assert(!result)
  }

  "User" should "not be valid as his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn (None)
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn (false)
    val result = userValidator.userIsValid(user)
    assert(!result)
  }

  "User" should "not be valid as his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(user.companyName)) thenReturn (None)
    when(mockedEmailValidator.emailIdIsValid(user.emailId)) thenReturn (false)
    val result = userValidator.userIsValid(user)
    assert(!result)
  }
}