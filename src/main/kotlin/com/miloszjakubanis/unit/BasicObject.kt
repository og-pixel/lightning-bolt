package com.miloszjakubanis.unit

import com.miloszjakubanis.graphics.Sprite

abstract class BasicObject(
    var speed: Double = 60.0
) {

    val hitBox: HitBox = NoHitbox()
    abstract val sprite: Sprite



}