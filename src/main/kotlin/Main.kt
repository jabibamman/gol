package com.gameoflife

fun main() {
    val map = Grid(3, 3)

    map.setAsAlive(0, 0)
    map.setAsAlive(0,2)
    map.setAsAlive(1, 1)
    map.setAsAlive(2, 0)

    println(map)
}