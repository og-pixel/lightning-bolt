package com.miloszjakubanis.unit

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.graphics.Sprite
import javafx.scene.image.Image

class Player(
    override val sprite: Sprite
) : Controllable, BasicObject(1000.0) {

    var xPos = sprite.xPos
        private set
    var yPos = sprite.yPos
        private set

    override fun readInput(pressedButton: Button) {
        if (pressedButton == BUTTON_UP) yPos -= (speed/60)
        if (pressedButton == BUTTON_DOWN) yPos += (speed/60)
        if (pressedButton == BUTTON_LEFT) xPos -= (speed/60)
        if (pressedButton == BUTTON_RIGHT) xPos += (speed/60)

        sprite.xPos = xPos
        sprite.yPos = yPos

//        println("xPos:$xPos   yPos:$yPos")
    }


}