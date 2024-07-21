package com.gameoflife

class Grid(x: Int, y: Int) {
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
        return this.size.copy(x = this.size.x - 1, y = this.size.y - 1)
    }

    fun setAsAlive(x: Int, y: Int) {
        this.map[x][y] = 'X'
    }

    fun isAlive(x: Int, y: Int): Boolean {
        return this.map[x][y] == 'X'
    }

    fun setAsDead(x: Int, y: Int) {
        this.map[x][y] = '-'
    }

    fun isDead(x: Int, y: Int): Boolean {
        return this.map[x][y] == '-'
    }

    override fun toString(): String {
        var string = ""

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