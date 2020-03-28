package com.miloszjakubanis.controls

import java.awt.event.KeyAdapter

class DefaultInput : Input, Buttons, KeyAdapter() {

    override val BUTTON_1: String
        get() = "p"
    override val BUTTON_2: String
        get() = "b"
    override val BUTTON_3: String
        get() = "c"
    override val BUTTON_4: String
        get() = "d"
    override val BUTTON_5: String
        get() = "e"
    override val BUTTON_UP: String
        get() = "w"
    override val BUTTON_LEFT: String
        get() = "a"
    override val BUTTON_RIGHT: String
        get() = "d"
    override val BUTTON_DOWN: String
        get() = "s"

//    lateinit var loop: GameLoop
//
//    override fun attach(loop: GameLoop) {
//        this.loop = loop
//    }

//    override fun getKeyPressed(key: String): ButtonsEnum? {
//
//    }
}