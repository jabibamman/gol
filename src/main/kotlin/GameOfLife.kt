package com.gameoflife

class GameOfLife(private val grid: Grid) {

    fun update() {
        val newGrid = Grid(grid.getLimits().x + 1, grid.getLimits().y + 1)

        for (i in 0..grid.getLimits().x) {
            for (j in 0..grid.getLimits().y) {
                val liveNeighbours = countLiveNeighbours(i, j)

                if (grid.isAlive(i, j)) {
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        newGrid.setAsDead(i, j)
                    } else {
                        newGrid.setAsAlive(i, j)
                    }
                } else {
                    if (liveNeighbours == 3) {
                        newGrid.setAsAlive(i, j)
                    } else {
                        newGrid.setAsDead(i, j)
                    }
                }
            }
        }

        for (i in 0..grid.getLimits().x) {
            for (j in 0..grid.getLimits().y) {
                grid.map[i][j] = newGrid.map[i][j]
            }
        }
    }

    private fun countLiveNeighbours(row: Int, col: Int): Int {
        var numLiveNeighbours = 0

        val (maxColIndex, maxRowIndex) = this.grid.getLimits()

        val startRowIndex = if (row == 0) { 0 } else { row - 1 }
        val endRowIndex = if (row == maxRowIndex) { maxRowIndex } else { row + 1 }
        val startColIndex = if (col == 0) { 0 } else { col - 1}
        val endColIndex = if (col == maxColIndex) { maxColIndex } else { col + 1 }

        for (i in startRowIndex..endRowIndex) {
            for (j in startColIndex..endColIndex) {
                if (i == row && j == col) {
                    continue
                }
                if (this.grid[i][j] == 'X') {
                    numLiveNeighbours += 1
                }
            }
        }

        return numLiveNeighbours
    }
}
