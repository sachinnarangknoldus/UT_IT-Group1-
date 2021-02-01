package com.knoldus.implement
import com.knoldus.traits.DivideAndFibonacci
import scala.util.control.Breaks.break

class DivideAndFibonacciImplement extends DivideAndFibonacci {
  override def divide(x: Int, y: Int): Int = x / y

  override def fibonacci(n: Int): String = {
    var (prev, next, count) = (-1,1, 0)
    var output : String=""
    if (n <= 0) {
      return "Invalid Input"
    }

    while (count < n) {
      val sum = prev + next
      output +=sum.toString+" "
      prev = next
      next = sum
      count += 1
    }
    return output
  }

}