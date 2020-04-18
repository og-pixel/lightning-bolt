package com.miloszjakubanis.gameEngine.board

interface GameLayer {

    val boardWidth: Int
    val boardHeight: Int

    val tileWidth: Double
    val tileHeight: Double

    fun getTile(xPos: Int, yPos: Int): Tile
}