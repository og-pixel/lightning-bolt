package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.BasicObject
import com.miloszjakubanis.gameObject.graphics.Animation

class Player(
    xPos: Double,
    yPos: Double,
    animation: Animation,
    speed: Double = 60.0

) : Controllable, Character(xPos, yPos, animation, speed) {

    val gameSpeed: Int
        get() = GameLoop.ticksPerSecond

    override fun readInput(pressedButton: Button) {
        if (pressedButton == BUTTON_UP) {
            yPos -= (speed / gameSpeed)
            return
        }
        if (pressedButton == BUTTON_DOWN) {
            yPos += (speed / gameSpeed)
            return
        }
        if (pressedButton == BUTTON_LEFT) {
            xPos -= (speed / gameSpeed)
            return
        }
        if (pressedButton == BUTTON_RIGHT) {
            xPos += (speed / gameSpeed)
            return
        }

    }

    override fun readInputs(pressedButtons: List<Button>) {
        for (button in pressedButtons) {
            readInput(button)
        }
    }


}