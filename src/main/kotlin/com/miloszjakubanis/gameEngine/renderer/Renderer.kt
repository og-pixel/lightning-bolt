package com.miloszjakubanis.gameEngine.renderer

import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.levels.GameLevel

interface Renderer {

    //TODO should be deleted
    var listOfLayers: MutableList<GameLayer>

    var listOfGameLevels: MutableList<GameLevel>

    fun renderVisible()

    fun renderVisible(index: Int)

    fun renderVisible(layer: GameLayer)
}