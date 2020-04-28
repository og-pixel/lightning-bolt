package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.gameObject.Position
import com.miloszjakubanis.gameObject.GameObject

class EnvironmentObject(
    position: Position,
    speed: Double = 0.0
) : GameObject(position, speed = speed) {
}