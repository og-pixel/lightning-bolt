package com.miloszjakubanis.gameObject

import com.miloszjakubanis.Position
import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.artificialIntelligence.Ai
import com.miloszjakubanis.gameObject.hitbox.HitBox
import com.miloszjakubanis.gameObject.sound.SoundSource
import com.miloszjakubanis.gameObject.sprite.AnimationDirection
import com.miloszjakubanis.gameObject.sprite.ObjectSprites

abstract class GameObject(
//    var xPos: Double = 0.0,
//    var yPos: Double = 0.0,
    var position: Position,
    var objectSprites: ObjectSprites? = null,
    var speed: Double
) {

   /*abstract*/ var hitBox: HitBox? = null
   /*abstract*/ var soundSource: SoundSource? = null
   /*abstract*/ var ai: Ai? = null
//   /*abstract*/ var animation: Animation? = null

    var objectName = ""

    val xPos: Double = position.xPos
    val yPos: Double = position.yPos

    //TODO I repeat this val a couple of times
    val gameSpeed: Int
        get() = GameLoop.ticksPerSecond

    fun updateObject() {
        hitBox?.checkHitbox()
        val decision = ai?.createDecision()
    }

    fun moveUp(){
        objectSprites?.currentDirection = AnimationDirection.UP
        position.yPos -= (speed / gameSpeed)
    }

    fun moveDown(){
        objectSprites?.currentDirection = AnimationDirection.DOWN
        position.yPos += (speed / gameSpeed)
    }

    fun moveLeft(){
        objectSprites?.currentDirection = AnimationDirection.LEFT
        position.xPos -= (speed / gameSpeed)
    }

    fun moveRight(){
        objectSprites?.currentDirection = AnimationDirection.RIGHT
        position.xPos += (speed / gameSpeed)
    }
}