package com.miloszjakubanis.gameObject

import com.miloszjakubanis.gameObject.artificialIntelligence.Ai
import com.miloszjakubanis.gameObject.spriteGraphics.SpriteAnimation
import com.miloszjakubanis.gameObject.hitbox.HitBox
import com.miloszjakubanis.gameObject.sound.SoundSource
import com.miloszjakubanis.gameObject.spriteGraphics.GameSprite

abstract class BasicObject(
    var xPos: Double = 0.0,
    var yPos: Double = 0.0,
    var gameSprite: GameSprite? = null,
    var speed: Double
) {

   /*abstract*/ var hitBox: HitBox? = null
   /*abstract*/ var soundSource: SoundSource? = null
   /*abstract*/ var ai: Ai? = null
//   /*abstract*/ var animation: Animation? = null

    var objectName = ""


    fun updateObject() {
        hitBox?.checkHitbox()
        val decision = ai?.createDecision()
    }
}