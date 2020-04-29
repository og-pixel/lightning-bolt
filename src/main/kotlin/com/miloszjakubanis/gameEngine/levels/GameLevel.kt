package com.miloszjakubanis.gameEngine.levels

import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.layer.ObjectVisibility
import com.miloszjakubanis.gameEngine.layer.gui.GuiLayer
import com.miloszjakubanis.gameEngine.objectFactory.ObjectFactory
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player

interface GameLevel {

    val playerObject: Player
    var allObjects: HashMap<ObjectVisibility, MutableList<GameObject>>
    var guiLayer: GuiLayer
    var gameLayers: MutableList<GameLayer>
    val objectFactory: ObjectFactory

    /**
     * Function meant to update all objects inside a level
     */
    //TODO change name?
    fun gameTick() {
        val allObjects = allObjects[ObjectVisibility.VISIBLE]
        allObjects!!.forEach { e ->
            e.objectSprites!!.currentAnimation.nextFrame()
        }
    }
}