package com.miloszjakubanis.gameObject.graphics

import javafx.scene.image.Image

class Frame(
    private val width: Double = 25.0,
    private val height: Double = 25.0,
    var stance: AnimationStance = AnimationStance.IDLE,
    val image: Image
)