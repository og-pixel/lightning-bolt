package com.miloszjakubanis.gameEngine.layer

import com.miloszjakubanis.gameEngine.LoadStatus
import com.miloszjakubanis.gameObject.`object`.GroundTile
import com.miloszjakubanis.gameObject.`object`.Tile
import com.miloszjakubanis.gameObject.sprite.SpriteFactory

class BoardLayer(
    override val layerWidth: Int,
    override val layerHeight: Int,
    override val tileWidth: Double,
    override val tileHeight: Double
) : GameLayer, LoadStatus {

    override var currentIteration: Int = 0

    override val noOfIterations: Int
        get() = layerHeight * layerWidth

    var tileMatrix: MutableList<MutableList<Tile>> = ArrayList()

    override fun getTile(xPos: Int, yPos: Int): Tile {
        return tileMatrix[yPos][xPos]
    }

    init {
        if (layerHeight < 1 || layerWidth < 1) {
            throw Exception("Board needs to be at least 1 by 1")
        }

        for (y in 0 until layerHeight) {
            tileMatrix.add(ArrayList())
            for (x in 0 until layerWidth) {
                SpriteFactory.height = tileHeight
                SpriteFactory.width = tileWidth
                //TODO scale for now does not work properly if tile size is wrong
                SpriteFactory.scale = 1.0
                val frame = SpriteFactory.getSingleFrame("sprites/terrain/grass.png", false)
                tileMatrix[y].add(GroundTile(frame))

                currentIteration++
//                test()
            }
        }
        //TODO I dont like it
        clearLoading()
    }



}
