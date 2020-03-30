package com.miloszjakubanis.graphics

import javafx.scene.image.Image

class Sprite(
    var xPos: Double,
    var yPos: Double,
    private val width: Double = 20.0,
    private val height: Double = 20.0,
    val image: Image = Image("img/1.jpg", width, height, true, true)
)