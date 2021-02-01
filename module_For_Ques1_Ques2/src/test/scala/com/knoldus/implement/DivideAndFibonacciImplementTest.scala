package com.knoldus.implement

import org.scalatest.FlatSpec


class DivideAndFibonacciImplementTest extends FlatSpec {
  val testFibo=new DivideAndFibonacciImplement()
  val testDivide =new DivideAndFibonacciImplement()

  // 2 test cases for checking fibonacci series.
  "When we give a negative number it" should " not accept it and gives an error" in {
    assert(testFibo.fibonacci(-7).equals("Invalid Input"))
  }

  "When we give a positive number it" should "accept it" in {
    assert(testFibo.fibonacci(7).equals("0 1 1 2 3 5 8 "))
  }

  // 2 test cases for checking divide function.

  "A number 6" should "return 2 when divided 3" in {
    assert(testDivide.divide(6,3)==2)
  }
  "it" should "throw Divide by zero exception when any number is divide by 0" in
  {
    assertThrows[ArithmeticException](testDivide.divide(4,0))
  }
}
