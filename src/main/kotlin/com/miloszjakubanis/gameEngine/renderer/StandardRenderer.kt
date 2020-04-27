package com.miloszjakubanis.gameEngine.renderer

import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.levels.GameLevel

class StandardRenderer(
    override var listOfLayers: MutableList<GameLayer> = ArrayList(),
    override var listOfGameLevels: MutableList<GameLevel> = ArrayList()
) : Renderer {

    override fun renderVisible() {
        listOfGameLevels.forEach { e ->
        }
    }


    override fun renderVisible(index: Int) {
        TODO("Not yet implemented")
    }

    override fun renderVisible(layer: GameLayer) {
        TODO("Not yet implemented")
    }
}