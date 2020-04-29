package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.sprite.SpriteFactory
import com.miloszjakubanis.gameObject.sprite.SpriteFrame

sealed class Tile(
    val spriteFrame: SpriteFrame
) {
    var isFocused: Boolean = false
    abstract val focusedFrame: SpriteFrame

    fun getFrame(): SpriteFrame {
        return if (isFocused) {
            focusedFrame
        } else {
            spriteFrame
        }
    }
}

class GroundTile(
    spriteFrame: SpriteFrame
) : Tile(spriteFrame) {

    override val focusedFrame: SpriteFrame

    //TODO hard coded what focused means
    init {
        SpriteFactory.height = spriteFrame.height
        SpriteFactory.width = spriteFrame.width
        focusedFrame = SpriteFactory.getSingleFrame("sprites/terrain/border.png")


    }

}
