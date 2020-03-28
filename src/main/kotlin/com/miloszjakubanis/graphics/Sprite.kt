package com.miloszjakubanis.graphics

import javafx.scene.image.Image

class Sprite {
    private var xPos: Int
    private var yPos: Int
    private val width: Int
    private val height: Int

    val image: Image? = null

    constructor(xPos: Int,
                yPos: Int){
        this.xPos = xPos
        this.yPos = yPos
        this.width = 20
        this.height = 20
    }

    constructor(xPos: Int,
                yPos: Int,
                width: Int,
                height: Int){
        this.xPos = xPos
        this.yPos = yPos
        this.width = width
        this.height = height
    }

}