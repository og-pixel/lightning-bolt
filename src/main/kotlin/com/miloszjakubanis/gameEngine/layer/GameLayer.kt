package com.miloszjakubanis.gameEngine.layer

interface GameLayer: Layer {

    val tileWidth: Double
    val tileHeight: Double

    fun getTile(xPos: Int, yPos: Int): Tile
}