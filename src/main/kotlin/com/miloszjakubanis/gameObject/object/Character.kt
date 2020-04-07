package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.BasicObject
import com.miloszjakubanis.gameObject.graphics.Animation

open class Character(
    xPos: Double,
    yPos: Double,
    override var animation: Animation,
    speed: Double = 60.0
) : BasicObject(xPos, yPos, speed) {
}