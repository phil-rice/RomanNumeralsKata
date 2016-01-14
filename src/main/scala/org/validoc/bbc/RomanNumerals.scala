package org.validoc.bbc

trait RomanNumeralGenerator {
  /** Given a positive integer return the roman numeral String representing it */
  def generate(number: Int): String
}

abstract class RomanNumeralException(msg: String) extends Exception(msg)
class RomanNumeralAssertion(msg: String) extends Exception(msg)
class RomanNumeralCannotBeNegative(msg: String) extends Exception(msg)

/** Implementation of a RomanNumeralGenerator using a recursive approach */
trait RecursiveRomanNumeralGenerator extends RomanNumeralGenerator {
  protected def generate(refernenceListLeft: List[(String, Int)], number: Int): String = refernenceListLeft match {
    case (string, value) :: tail =>
      val count = number / value
      val remainder = number % value
      string * count + generate(tail, remainder)
    case Nil if number != 0 => throw new RomanNumeralAssertion("Software Exception: if the reference list is empty, the number should be zero")
    case Nil                => ""
  }
  def generate(number: Int): String =
    if (number < 0) throw new RomanNumeralCannotBeNegative("Cannot have a negative roman number") else
      generate(RomanNumeralGenerator.reference, number)
}

object RomanNumeralGenerator {
  val reference = List(
    "M" -> 1000, "CM" -> 900, "D" -> 500, "CD" -> 400, "C" -> 100, "XC" -> 90,
    "L" -> 50, "XL" -> 40, "X" -> 10, "IX" -> 9, "V" -> 5, "IV" -> 4, "I" -> 1)
}