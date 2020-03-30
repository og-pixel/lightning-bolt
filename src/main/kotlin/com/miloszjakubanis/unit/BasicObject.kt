package com.miloszjakubanis.unit

import com.miloszjakubanis.graphics.Sprite
import com.miloszjakubanis.unit.sound.SoundSource

abstract class BasicObject(
    var speed: Double = 60.0
) {

    val hitBox: HitBox = NoHitbox()
    val soundSource: SoundSource? = null

    abstract val sprite: Sprite



}