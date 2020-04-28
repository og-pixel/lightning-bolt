package com.miloszjakubanis.gameEngine.levels

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.layer.ObjectVisibility
import com.miloszjakubanis.gameEngine.layer.gui.GuiLayer
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player

interface GameLevel {

    var allObjects: HashMap<ObjectVisibility, MutableList<GameObject>>

    val playerObject: Player

    var guiLayer: GuiLayer
    var listGameLayers: MutableList<GameLayer>

    /**
     * Function meant to update all objects inside a level
     */
    //TODO change name?
    fun gameTick() {
        val zz = allObjects[ObjectVisibility.VISIBLE]
        zz!!.forEach { e ->
            e.objectSprites!!.currentAnimation.nextFrame()
        }
    }
}