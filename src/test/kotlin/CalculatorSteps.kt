package com.gameoflife

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.assertEquals

class CalculatorSteps {

    private lateinit var calculator: Calculator
    private var result: Int = 0

    @Given("I have a calculator")
    fun iHaveACalculator() {
        calculator = Calculator()
    }

    @When("I add {int} and {int}")
    fun iAddAnd(a: Int, b: Int) {
        result = calculator.add(a, b)
    }

    @Then("the result should be {int}")
    fun theResultShouldBe(expectedResult: Int) {
        assertEquals(expectedResult, result)
    }
}
