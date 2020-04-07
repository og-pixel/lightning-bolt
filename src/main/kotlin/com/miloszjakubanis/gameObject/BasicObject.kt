package com.miloszjakubanis.gameObject

import com.miloszjakubanis.gameObject.artificialIntelligence.Ai
import com.miloszjakubanis.gameObject.graphics.Animation
import com.miloszjakubanis.gameObject.hitbox.HitBox
import com.miloszjakubanis.gameObject.hitbox.NoHitbox
import com.miloszjakubanis.gameObject.sound.SoundSource

abstract class BasicObject(
    var xPos: Double = 0.0,
    var yPos: Double = 0.0,
    var speed: Double
) {

    val hitBox: HitBox = NoHitbox()
    val soundSource: SoundSource? = null
    val ai: Ai? = null
    abstract var animation: Animation

    var objectName = ""


    fun updateObject() {
        hitBox.checkHitbox()
//        soundSource?.
        val decision = ai?.createDecision()


    }


}