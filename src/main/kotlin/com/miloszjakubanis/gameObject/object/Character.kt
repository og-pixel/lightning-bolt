package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.Position
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.sprite.ObjectSprites

open class Character(
//    xPos: Double,
//    yPos: Double,
    position: Position,
    objectSprites: ObjectSprites,
    speed: Double = 60.0
) : GameObject(position, objectSprites, speed)
