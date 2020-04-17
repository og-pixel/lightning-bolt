package com.miloszjakubanis.gameObject.spriteGraphics

import javafx.scene.image.Image

object AnimationFactory {

    var width = 0.0
    var height = 0.0
    var scale = 1.0
    var animationSpeed = 1
    var animationLoop = true

    private var frameList = ArrayList<Frame>()

    /**
     * Returns itself so it can be chained to add multiple frames at the same time and returned with
     * getAnimation()
     */
    fun addFrame(img: String): AnimationFactory {

        frameList.add(
            Frame(
                width * scale, height * scale, image = Image(
                    img, width * scale, height * scale, true, true
                )
            )
        )
        return this
    }

    fun getAnimation(
        animationStance: AnimationStance,
        animationDirection: AnimationDirection
    ): SpriteAnimation {
        val product = SpriteAnimation(
            frameList, animationLoop, animationSpeed,
            animationStance, animationDirection
        )
        flush()
        return product
    }

    //Resets data in factory for reuse
    private fun flush() {
        width = 0.0
        height = 0.0
        scale = 1.0
        animationSpeed = 1
        animationLoop = true
        frameList = ArrayList()
    }
}