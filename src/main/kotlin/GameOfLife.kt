package com.gameoflife

data class MapSize(var x: Int, var y: Int)

class Grid(private val x: Int, private val y: Int) {
    val map: MutableList<MutableList<Char>> = mutableListOf()
    private val size: MapSize = MapSize(x, y)

    init {
        for (i in 0 until x) {
            val horizontalCells: MutableList<Char> = mutableListOf()
            for (j in 0 until y) {
                horizontalCells.add('-')
            }
            this.map.add(horizontalCells)
        }
    }

    fun getLimits(): MapSize {
        return this.size.copy(this.size.x - 1, this.size.y - 1)
    }

    fun setAsAlive(x: Int, y: Int): Unit {
        this.map[x][y] = 'X'
    }

    fun isAlive(x: Int, y: Int): Boolean {
        return this.map[x][y] == 'X'
    }

    fun setAsDead(x: Int, y: Int): Unit {
        this.map[x][y] = '-'
    }

    fun isDead(x: Int, y: Int): Boolean {
        return this.map[x][y] == '-'
    }

    override fun toString(): String {
        var string: String = ""

        for (row in this.map) {
            string += '|'
            for (cell in row) {
                string += "$cell|"
            }
            string += '\n'
        }

        return string.trim()
    }

    operator fun get(index: Int): MutableList<Char> {
        return this.map[index]
    }
}

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

    fun countLiveNeighbours(row: Int, col: Int): Int {
        var numLiveNeighbours: Int = 0

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
