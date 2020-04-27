package com.miloszjakubanis.gameEngine.layer

import com.miloszjakubanis.gameObject.sprite.SpriteFrame

sealed class Tile(
    val spriteFrame: SpriteFrame
) {
    var isFocused: Boolean = false
}

class GroundTile(
    spriteFrame: SpriteFrame
): Tile(spriteFrame)
