package com.gameoflife

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.assertEquals

class GolTests {

    private lateinit var grid: Array<Array<Boolean>>

    @Given("a {int}x{int} grid")
    fun aGrid(rows: Int, cols: Int) {
        grid = Array(rows) { Array(cols) { false } }
    }

    @Given("a live cell at [{int}, {int}]")
    fun aLiveCellAt(row: Int, col: Int) {
        grid[row][col] = true
    }

    @Given("a dead cell at [{int}, {int}]")
    fun aDeadCellAt(row: Int, col: Int) {
        grid[row][col] = false
    }

    @When("I update the grid")
    fun iUpdateTheGrid() {
        grid = GameOfLife().update(grid)
    }

    @Then("the cell at [{int}, {int}] should be alive")
    fun theCellAtShouldBeAlive(row: Int, col: Int) {
        assertEquals(true, grid[row][col])
    }

    @Then("the cell at [{int}, {int}] should be dead")
    fun theCellAtShouldBeDead(row: Int, col: Int) {
        assertEquals(false, grid[row][col])
    }
}
