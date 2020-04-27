package com.miloszjakubanis.gameEngine.levels

import com.miloszjakubanis.gameEngine.layer.gui.GuiLayer
import com.miloszjakubanis.gameObject.GameObject

interface GameLevel {

    val visibleObjects: MutableList<GameObject>
    val notVisibleObjects: MutableList<GameObject>

    var guiLayer: GuiLayer
    var listGameLayers: MutableList<GameLevel>
}