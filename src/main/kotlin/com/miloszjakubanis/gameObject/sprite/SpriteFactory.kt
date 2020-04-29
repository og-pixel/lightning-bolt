package com.miloszjakubanis.gameObject.sprite

import javafx.scene.Group
import javafx.scene.effect.BlendMode
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javax.swing.GroupLayout

/**
 * Creates singular "frames" and
 * whole animations
 */
//TODO  change to regualr class?
object SpriteFactory {

    var width = 0.0
    var height = 0.0
    var scale = 1.0
    var animationSpeed = 1
    var animationLoop = true

    private var frameList = ArrayList<SpriteFrame>()

    /**
     * Returns itself so it can be chained to add multiple frames at the same time and returned with
     * getAnimation()
     */
    fun addFrame(img: String): SpriteFactory {

        frameList.add(
            SpriteFrame(
                width * scale, height * scale, image = Image(
                    img, width * scale, height * scale, true, true
                )
            )
        )
        return this
    }

    fun getSingleFrame(
        img: String,
        flushOnReturn: Boolean = true
    ): SpriteFrame {
        val frame = SpriteFrame(
            width * scale, height * scale, image = Image(
                img, width * scale, height * scale, true, true
            )
        )
        if (flushOnReturn) flush()
        return frame
    }

    fun getAnimation(
        animationStance: AnimationStance,
        animationDirection: AnimationDirection,
        flushOnReturn: Boolean = true
    ): SpriteAnimation {
        val product = SpriteAnimation(
            frameList, animationLoop, animationSpeed,
            animationStance, animationDirection
        )
        if (flushOnReturn) flush()
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