package com.miloszjakubanis.gameObject

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.artificialIntelligence.Ai
import com.miloszjakubanis.gameObject.hitbox.HitBox
import com.miloszjakubanis.gameObject.orders.Command
import com.miloszjakubanis.gameObject.orders.CommandList
import com.miloszjakubanis.gameObject.sound.SoundSource
import com.miloszjakubanis.gameObject.sprite.AnimationDirection
import com.miloszjakubanis.gameObject.sprite.AnimationStance
import com.miloszjakubanis.gameObject.sprite.ObjectSprites

abstract class GameObject(
    var position: Position = Position(),
    var objectSprites: ObjectSprites? = null,
    var speed: Double = 0.0
) {

    var hitBox: HitBox? = null
    var soundSource: SoundSource? = null
    var ai: Ai? = null

    //TODO change
    var commandList: CommandList = CommandList()

    val xPos: Double
        get() = position.xPos
    val yPos: Double
        get() = position.yPos

    //TODO I repeat this val a couple of times
    val gameSpeed: Int
        get() = GameLoop.ticksPerSecond

    fun updateObject() {
//        commandList.getNextCommand()?.executeCommand()
    }

    fun nextFrame() {
        throw Exception("this does not work")
        val animationStance: AnimationStance = objectSprites!!.currentStance
        val animationDirection: AnimationDirection = objectSprites!!.currentDirection
        objectSprites?.spriteMap

    }

    fun moveUp() {
        objectSprites?.currentDirection = AnimationDirection.UP
        position.yPos -= (speed / gameSpeed)
    }

    fun moveDown() {
        objectSprites?.currentDirection = AnimationDirection.DOWN
        position.yPos += (speed / gameSpeed)
    }

    fun moveLeft() {
        objectSprites?.currentDirection = AnimationDirection.LEFT
        position.xPos -= (speed / gameSpeed)
    }

    fun moveRight() {
        objectSprites?.currentDirection = AnimationDirection.RIGHT
        position.xPos += (speed / gameSpeed)
    }
}