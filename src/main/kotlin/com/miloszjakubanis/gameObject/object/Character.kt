package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.BasicObject
import com.miloszjakubanis.gameObject.spriteGraphics.GameSprite
import com.miloszjakubanis.gameObject.spriteGraphics.SpriteAnimation

open class Character(
    xPos: Double,
    yPos: Double,
    gameSprite: GameSprite,
    speed: Double = 60.0
) : BasicObject(xPos, yPos, gameSprite, speed) {
}