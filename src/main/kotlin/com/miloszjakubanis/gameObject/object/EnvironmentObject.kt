package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.BasicObject
import com.miloszjakubanis.gameObject.graphics.Animation

class EnvironmentObject(
    override var animation: Animation, xPos: Double, yPos: Double
) : BasicObject(xPos, yPos, speed = 0.0) {
}