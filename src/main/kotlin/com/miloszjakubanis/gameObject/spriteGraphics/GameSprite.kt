package com.miloszjakubanis.gameObject.spriteGraphics

import javafx.scene.image.Image
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//TODO probably a stupid name but this is meant to store all animations that one object would have
// with all stances and differences
class GameSprite {

    enum class AnimationDirection {
        UP, DOWN, LEFT, RIGHT
    }

    enum class AnimationStance {
        IDLE, MOVING, ATTACKING, DEFENDING, SPECIAL
    }

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
        fun addFrame(
            img: String
        ): AnimationFactory {
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
            val spriteAnimation = SpriteAnimation(frameList, animationLoop, animationSpeed)
            flush()
            return spriteAnimation
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

    var map = HashMap<AnimationDirection,
                HashMap<AnimationStance, SpriteAnimation?>>()

    init {
        for (x in AnimationDirection.values()) {
            map[x] = HashMap()
            for (y in AnimationStance.values()){
                map[x]?.set(y, null)
            }
        }
    }

    fun getAnimation(
        animationDirection: AnimationDirection,
        animationStance: AnimationStance
    ): SpriteAnimation {
        return map[animationDirection]?.get(animationStance)!!
    }

    fun addAnimation(
        animationDirection: AnimationDirection,
        animationStance: AnimationStance,
        animation: SpriteAnimation
    ) {
        val z = map[animationDirection]?.get(animationStance)
    }
}