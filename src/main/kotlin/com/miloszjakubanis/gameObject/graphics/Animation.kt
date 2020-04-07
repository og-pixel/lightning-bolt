package com.miloszjakubanis.gameObject.graphics

import com.miloszjakubanis.gameEngine.GameLoop

//TODO Animation is kinda counter intuitive name for this class
//TODO animationSpeed is a number of full cycles per one second (60 frames), so 3 frame animation would tick every 20th of
// a frame
class Animation(
    private val frameList: List<Frame>,
    private var animationLoop: Boolean = true,
    private var animationSpeed: Int = 1
) {
    //TODO for more versatile animation list
    //TODO add this option later
    var animationStance = AnimationStance.IDLE
    var animationDirection = AnimationDirection.DOWN


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