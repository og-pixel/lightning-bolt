package com.miloszjakubanis.unit

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.graphics.Sprite
import com.miloszjakubanis.unit.sound.SoundSource
import javafx.scene.image.Image

class Player(
    override val sprite: Sprite
) : Controllable, BasicObject(500.0) {

    override fun readInput(pressedButton: Button) {
        if (pressedButton == BUTTON_UP) sprite.yPos -= (speed/60)
        if (pressedButton == BUTTON_DOWN) sprite.yPos += (speed/60)
        if (pressedButton == BUTTON_LEFT) sprite.xPos -= (speed/60)
        if (pressedButton == BUTTON_RIGHT) sprite.xPos += (speed/60)

//        println("xPos:$xPos   yPos:$yPos")
    }


}