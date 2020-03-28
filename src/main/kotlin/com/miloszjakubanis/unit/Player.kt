package com.miloszjakubanis.unit

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import javafx.scene.image.Image

class Player : Controllable {

    var height = 50
    var width = 50

    var xPos = 0
        private set
    var yPos = 0
        private set

    //TODO change to sprite class
    var image = Image("img/1.jpg")

    override fun readInput(pressedButton: Button) {
        if (pressedButton == BUTTON_UP) yPos++
        if (pressedButton == BUTTON_DOWN) yPos--
        if (pressedButton == BUTTON_LEFT) xPos--
        if (pressedButton == BUTTON_RIGHT) xPos++

    }

}