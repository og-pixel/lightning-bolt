package com.miloszjakubanis.gameObject.`object`

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.spriteGraphics.AnimationDirection
import com.miloszjakubanis.gameObject.spriteGraphics.ObjectSprites

class Player(
    xPos: Double,
    yPos: Double,
    objectSprites: ObjectSprites = ObjectSprites(),
    speed: Double = 60.0
) : Controllable, Character(xPos, yPos, objectSprites, speed) {

    override fun readInput(pressedButton: Button) {
        if (pressedButton == BUTTON_UP) {
            moveUp()
            return
        }
        if (pressedButton == BUTTON_DOWN) {
            moveDown()
            return
        }
        if (pressedButton == BUTTON_LEFT) {
            moveLeft()
            return
        }
        if (pressedButton == BUTTON_RIGHT) {
            moveRight()
            return
        }
    }

    override fun readInputs(pressedButtons: List<Button>) {
        for (button in pressedButtons) {
            readInput(button)
        }
    }
}