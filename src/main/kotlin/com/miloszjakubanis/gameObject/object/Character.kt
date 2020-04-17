package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.spriteGraphics.ObjectSprites

open class Character(
    xPos: Double,
    yPos: Double,
    objectSprites: ObjectSprites,
    speed: Double = 60.0
) : GameObject(xPos, yPos, objectSprites, speed)
