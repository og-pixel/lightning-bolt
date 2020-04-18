package com.miloszjakubanis.gameObject

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.artificialIntelligence.Ai
import com.miloszjakubanis.gameObject.hitbox.HitBox
import com.miloszjakubanis.gameObject.sound.SoundSource
import com.miloszjakubanis.gameObject.spriteGraphics.AnimationDirection
import com.miloszjakubanis.gameObject.spriteGraphics.ObjectSprites

abstract class GameObject(
    var xPos: Double = 0.0,
    var yPos: Double = 0.0,
    var objectSprites: ObjectSprites? = null,
    var speed: Double
) {

   /*abstract*/ var hitBox: HitBox? = null
   /*abstract*/ var soundSource: SoundSource? = null
   /*abstract*/ var ai: Ai? = null
//   /*abstract*/ var animation: Animation? = null

    var objectName = ""

    //TODO I repeat this val a couple of times
    val gameSpeed: Int
        get() = GameLoop.ticksPerSecond

    fun updateObject() {
        hitBox?.checkHitbox()
        val decision = ai?.createDecision()
    }

    fun moveUp(){
        objectSprites?.currentDirection = AnimationDirection.UP
        yPos -= (speed / gameSpeed)
    }

    fun moveDown(){
        objectSprites?.currentDirection = AnimationDirection.DOWN
        yPos += (speed / gameSpeed)
    }

    fun moveLeft(){
        objectSprites?.currentDirection = AnimationDirection.LEFT
        xPos -= (speed / gameSpeed)
    }

    fun moveRight(){
        objectSprites?.currentDirection = AnimationDirection.RIGHT
        xPos += (speed / gameSpeed)
    }
}