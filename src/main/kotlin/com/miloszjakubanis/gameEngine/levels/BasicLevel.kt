package com.miloszjakubanis.gameEngine.levels

import com.miloszjakubanis.gameEngine.layer.gui.GuiLayer
import com.miloszjakubanis.gameObject.GameObject

class BasicLevel(
    override val visibleObjects: MutableList<GameObject>,
    override val notVisibleObjects: MutableList<GameObject>

) : GameLevel {
    override var guiLayer: GuiLayer
        get() = TODO("Not yet implemented")
        set(value) {}
    override var listGameLayers: MutableList<GameLevel>
        get() = TODO("Not yet implemented")
        set(value) {}
}