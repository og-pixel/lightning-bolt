package com.miloszjakubanis.gameObject.sprite

import com.miloszjakubanis.gameEngine.GameLoop

//TODO it should make sure that all frames are added and are correct size
class SpriteAnimation(
    private val spriteFrameList: List<SpriteFrame> = ArrayList(),
    private var animationLoop: Boolean = true,
    private var animationSpeed: Int = 1,
    var animationStance: AnimationStance,
    var animationDirection: AnimationDirection
) {

    private val frameDuration = (GameLoop.ticksPerSecond / spriteFrameList.size) * animationSpeed
    private var currentSpriteIndex = 0
    var currentSprite: SpriteFrame = spriteFrameList[currentSpriteIndex]

    private val currentFrame: Int
        get() = GameLoop.currentTick

    fun nextFrame() {
        if (currentFrame % frameDuration == 0) {
            currentSpriteIndex++
            if (currentSpriteIndex >= spriteFrameList.size) currentSpriteIndex = 0
            currentSprite = spriteFrameList[currentSpriteIndex]
        }
    }
}