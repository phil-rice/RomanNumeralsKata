package org.validoc.bbc

import org.scalatestplus.play.PlaySpec

class RomanNumeralGeneratorSpec extends PlaySpec with RecursiveRomanNumeralGenerator {

  "The string representing a roman numeral" should {
    "return the empty string for zero" in {
      //This is a standalone test as the specification doesn't say what to do in this case. 
      //I could have it throw an exception, or just (as now) return the empty string
      //Normally I would talk to the customer
      generate(0) mustBe ""
    }
    "throw an exception for a negative parameter" in {
      intercept[RomanNumeralCannotBeNegative] { generate(-1) }
    }
    "be generated by the generate method" in {
      generate(1) mustBe "I"
      generate(3) mustBe "III"
      generate(4) mustBe "IV"
      generate(5) mustBe "V"
      generate(6) mustBe "VI"
      generate(8) mustBe "VIII"
      generate(9) mustBe "IX"
      generate(10) mustBe "X"
      generate(14) mustBe "XIV"
      generate(15) mustBe "XV"
      generate(19) mustBe "XIX"
      generate(20) mustBe "XX"
      generate(23) mustBe "XXIII"
      generate(93) mustBe "XCIII"
      generate(99) mustBe "XCIX"
      generate(100) mustBe "C"
      generate(123) mustBe "CXXIII"
      generate(491) mustBe "CDXCI"
      generate(493) mustBe "CDXCIII"
      generate(494) mustBe "CDXCIV"
      generate(495) mustBe "CDXCV"
      generate(499) mustBe "CDXCIX"
      generate(500) mustBe "D"
      generate(539) mustBe "DXXXIX"
      generate(540) mustBe "DXL"
      generate(543) mustBe "DXLIII"
      generate(549) mustBe "DXLIX"
      generate(599) mustBe "DXCIX"
      generate(923) mustBe "CMXXIII"
      generate(1923) mustBe "MCMXXIII"
      generate(11923) mustBe "MMMMMMMMMMMCMXXIII"
    }
  }

  "ALl the strings in the reference values" should {
    "generate the reference string" in {
      for ((string, value) <- RomanNumeralGenerator.reference) {
        generate(value) mustBe string
      }
    }
  }

}