package com.miloszjakubanis.gameEngine.board

class GuiLayer(
    override val boardWidth: Int,
    override val boardHeight: Int,
    override val tileWidth: Double,
    override val tileHeight: Double
) : GameLayer {
    override fun getTile(xPos: Int, yPos: Int): Tile {
        TODO("Not yet implemented")
    }
}