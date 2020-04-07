package com.miloszjakubanis.gameObject.graphics

import javafx.scene.image.Image

object AnimationFactory {

    var width = 0.0
    var height = 0.0
    var scale = 1.0
    var animationSpeed = 1
    var animationLoop = true

    private var frameList = ArrayList<Frame>()

    fun createAnimation() {

    }

    fun addFrame(img: String) {
        frameList.add(
            Frame(
                width * scale, height * scale, image = Image(
                    img, width * scale, height * scale, true, true
                )
            )
        )
    }

    fun getAnimation(): Animation {
        val product = Animation(frameList, animationLoop, animationSpeed)
        flush()
        return product
    }

    private fun flush() {
        width = 0.0
        height = 0.0
        scale = 1.0
        animationSpeed = 1
        animationLoop = true
        frameList = ArrayList()
    }
}