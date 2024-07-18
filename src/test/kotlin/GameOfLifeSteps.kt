package com.gameoflife

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.assertEquals

class GameOfLifeSteps {

    private lateinit var grid: Grid

    @Given("a {int}x{int} grid")
    fun aGrid(rows: Int, cols: Int) {
        grid = Grid(rows, cols)
    }

    @Given("a live cell at [{int}, {int}]")
    fun aLiveCellAt(row: Int, col: Int) {
        grid.setAsAlive(row, col)
    }

    @Given("a dead cell at [{int}, {int}]")
    fun aDeadCellAt(row: Int, col: Int) {
        grid.setAsDead(row, col)
    }

    @When("I update the grid")
    fun iUpdateTheGrid() {
        grid = Grid(3, 3)

        GameOfLife(grid).update()
    }

    @Then("the cell at [{int}, {int}] should be alive")
    fun theCellAtShouldBeAlive(row: Int, col: Int) {
        assertEquals(true, grid.isAlive(row, col))
    }

    @Then("the cell at [{int}, {int}] should be dead")
    fun theCellAtShouldBeDead(row: Int, col: Int) {
        assertEquals(false, grid.isDead(row, col))
    }
}
