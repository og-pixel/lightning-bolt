package com.miloszjakubanis.gameObject.spriteGraphics

import com.miloszjakubanis.gameEngine.GameLoop

class SpriteAnimation(
    private val frameList: List<Frame> = ArrayList(),
    private var animationLoop: Boolean = true,
    private var animationSpeed: Int = 1,
    var animationStance: AnimationStance,
    var animationDirection: AnimationDirection
) {

    private val frameDuration = (GameLoop.ticksPerSecond / frameList.size) * animationSpeed
    private var currentSpriteIndex = 0
    var currentSprite: Frame = frameList[currentSpriteIndex]

    private val currentFrame: Int
        get() = GameLoop.currentTick

    fun nextFrame() {
        if (currentFrame % frameDuration == 0) {
            currentSpriteIndex++
            if (currentSpriteIndex >= frameList.size) currentSpriteIndex = 0
            currentSprite = frameList[currentSpriteIndex]
        }
    }
}