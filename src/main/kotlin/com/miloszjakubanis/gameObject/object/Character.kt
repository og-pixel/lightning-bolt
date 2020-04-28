package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.Position
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.sprite.ObjectSprites

open class Character(
    position: Position,
    objectSprites: ObjectSprites,
    speed: Double = 60.0
) : GameObject(position, objectSprites, speed)
