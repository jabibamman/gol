package com.gameoflife

import io.cucumber.datatable.DataTable
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.assertEquals

class GameOfLifeSteps {

    private lateinit var grid: Grid

    @Given("a 3x3 grid of dead cells")
    fun a3x3GridOfDeadCells() {
        grid = Grid(3, 3)
    }

    @Given("a coordinate positions system represented by the syntax {string}")
    fun aCoordinatePositionsSystem(syntax: String) { }

    @Given("the top left cell is at position [{int},{int}]")
    fun theTopLeftCellIsAtPosition(x: Int, y: Int) { }
    @Given("the bottom left cell is at position [{int},{int}]")
    fun theBottomLeftCellIsAtPosition(x: Int, y: Int) { }

    @Given("a live cell is graphically represented by the ASCII character {string}")
    fun aLiveCellIsGraphicallyRepresentedBy(character: String) { }

    @Given("a dead cell is graphically represented by the ASCII character {string}")
    fun aDeadCellIsGraphicallyRepresentedBy(character: String) { }

    @Given("borders are graphically represented by the ASCII character {string}")
    fun bordersAreGraphicallyRepresentedBy(character: String) { }

    @Then("the graphical representation should be")
    fun theGraphicalRepresentationShouldBe(dataTable: DataTable) {
        val expectedRepresentation = dataTable.asLists().map { it.joinToString("|", "|", "|") }
        val actualRepresentation = grid.toString().split("\n")
        assertEquals(expectedRepresentation, actualRepresentation)
    }

    @Given("the following {int}x{int} grid")
    fun theFollowingGrid(rows: Int, cols: Int, dataTable: DataTable) {
        grid = Grid(rows, cols)
        val data = dataTable.asLists(String::class.java)
        for (i in data.indices) {
            for (j in data[i].indices) {
                if (data[i][j] == "X") {
                    grid.setAsAlive(i, j)
                } else {
                    grid.setAsDead(i, j)
                }
            }
        }
    }

    @When("I update the grid")
    fun iUpdateTheGrid() {
        GameOfLife(grid).update()
    }

    @Then("the grid should be")
    fun theGridShouldBe(expectedDataTable: DataTable) {
        val expectedGrid = Grid(grid.getLimits().x + 1, grid.getLimits().y + 1)
        val data = expectedDataTable.asLists(String::class.java)
        for (i in data.indices) {
            for (j in data[i].indices) {
                if (data[i][j] == "X") {
                    expectedGrid.setAsAlive(i, j)
                } else {
                    expectedGrid.setAsDead(i, j)
                }
            }
        }
        assertEquals(expectedGrid.toString(), grid.toString())
    }

    @Then("the cell at [{int},{int}] should be alive")
    fun theCellAtShouldBeAlive(row: Int, col: Int) {
        assertEquals(true, grid.isAlive(row, col))
    }

    @Then("the cell at [{int},{int}] should be dead")
    fun theCellAtShouldBeDead(row: Int, col: Int) {
        assertEquals(false, grid.isDead(row, col))
    }

    @Then("the cell at position [{int},{int}] stays alive")
    fun theCellAtPositionStaysAlive(row: Int, col: Int) {
        assertEquals(true, grid.isAlive(row, col))
    }
}
