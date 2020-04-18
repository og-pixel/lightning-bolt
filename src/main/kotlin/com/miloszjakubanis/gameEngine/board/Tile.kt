package com.miloszjakubanis.gameEngine.board

import com.miloszjakubanis.gameObject.spriteGraphics.SpriteFactory
import com.miloszjakubanis.gameObject.spriteGraphics.SpriteFrame

sealed class Tile(
    val spriteFrame: SpriteFrame
) {
    var isFocused: Boolean = false
}

class GroundTile(
    spriteFrame: SpriteFrame
): Tile(spriteFrame) {

    //TODO delete, just for mouse focus testing
    val spriteFrame2: SpriteFrame

    init {
        SpriteFactory.width = 50.0
        SpriteFactory.height = 50.0
        spriteFrame2 = SpriteFactory.getSingleFrame("sprites/terrain/snow.png")
    }
}
