package com.miloszjakubanis.gameEngine.layer

import com.miloszjakubanis.gameObject.sprite.SpriteFactory

class BoardLayer(
    override val layerWidth: Int,
    override val layerHeight: Int,
    override val tileWidth: Double,
    override val tileHeight: Double
) : GameLayer {

    var tileMatrix: MutableList<MutableList<Tile>> = ArrayList()

    //TODO maybe I will use it for fake depth
    var zAxis = 3

    override fun getTile(xPos: Int, yPos: Int): Tile {

        return tileMatrix[yPos][xPos]
    }

    init {
        if (layerHeight < 1 || layerWidth < 1) {
            throw Exception("Board needs to be at least 1 by 1")
        }
        for (y in 0..layerHeight) {
            tileMatrix.add(ArrayList())
            for (x in 0..layerWidth) {
                SpriteFactory.height = 50.0
                SpriteFactory.width = 50.0
                SpriteFactory.scale = 1.0
                val frame = SpriteFactory.getSingleFrame("sprites/terrain/grass.png", false)

                tileMatrix[y].add(GroundTile(frame))
            }
        }
    }
}
