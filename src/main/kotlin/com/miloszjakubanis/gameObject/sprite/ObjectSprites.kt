package com.miloszjakubanis.gameObject.sprite

import kotlin.collections.HashMap

//TODO probably a stupid name but this is meant to store all animations that one object would have
// with all stances and differences
class ObjectSprites {

    var spriteMap = HashMap<AnimationDirection,
            HashMap<AnimationStance, SpriteAnimation?>>()

    var currentDirection = AnimationDirection.DOWN
    var currentStance = AnimationStance.IDLE

    init {
        for (direction in AnimationDirection.values()) {
            spriteMap[direction] = HashMap()
            for (stance in AnimationStance.values()) {
                spriteMap[direction]!![stance] = null
            }
        }
    }

    fun getAnimation(
        animationDirection: AnimationDirection,
        animationStance: AnimationStance
    ): SpriteAnimation {
        return spriteMap[animationDirection]?.get(animationStance)!!
    }

    val currentAnimation: SpriteAnimation
        get() = spriteMap[currentDirection]?.get(currentStance)!!

    fun addAnimation(animation: SpriteAnimation) {
        spriteMap[animation.animationDirection]!![animation.animationStance] = animation
    }

    //Set next frame
    fun nextFrame() {

    }

    //TODO I should stop using `e`
    private fun hasAllAnimations(): Boolean {
        spriteMap.forEach { e ->
            e.value.forEach { e2 ->
                if (e2.value == null) return false
            }
        }
        return true
    }
}