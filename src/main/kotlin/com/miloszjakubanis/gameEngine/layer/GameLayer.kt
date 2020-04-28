package com.miloszjakubanis.gameEngine.layer

import com.miloszjakubanis.gameObject.`object`.Tile

interface GameLayer: Layer {
    val tileWidth: Double
    val tileHeight: Double

    fun getTile(xPos: Int, yPos: Int): Tile
}