package com.gameoflife

import io.cucumber.datatable.DataTable
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.assertEquals

class GameOfLifeSteps {

    private lateinit var grid: Array<Array<Boolean>>

    @Given("the following {int}x{int} grid")
    fun theFollowingGrid(rows: Int, cols: Int, dataTable: DataTable) {
        grid = Array(rows) { Array(cols) { false } }
        val data = dataTable.asLists(String::class.java)
        for (i in data.indices) {
            for (j in data[i].indices) {
                grid[i][j] = data[i][j] == "X"
            }
        }
    }

    @When("I update the grid")
    fun iUpdateTheGrid() {
        grid = GameOfLife().update(grid)
    }

    @Then("the cell at [{int},{int}] should be alive")
    fun theCellAtShouldBeAlive(row: Int, col: Int) {
        assertEquals(true, grid[row][col])
    }

    @Then("the cell at [{int},{int}] should be dead")
    fun theCellAtShouldBeDead(row: Int, col: Int) {
        assertEquals(false, grid[row][col])
    }

    @Then("the grid should be")
    fun theGridShouldBe(expectedDataTable: DataTable) {
        val expectedGrid = Array(grid.size) { Array(grid[0].size) { false } }
        val data = expectedDataTable.asLists(String::class.java)
        for (i in data.indices) {
            for (j in data[i].indices) {
                expectedGrid[i][j] = data[i][j] == "X"
            }
        }
        assertEquals(expectedGrid, grid)
    }
}
