package com.miloszjakubanis.controls


interface Input: ConcreteButtons {

    fun getKeyPressed(key: String): Button {
        if(key == BUTTON_1) return Button.BUTTON_1
        if(key == BUTTON_2) return Button.BUTTON_2
        if(key == BUTTON_3) return Button.BUTTON_3
        if(key == BUTTON_4) return Button.BUTTON_4
        if(key == BUTTON_5) return Button.BUTTON_5
        if(key == BUTTON_UP) return Button.BUTTON_UP
        if(key == BUTTON_LEFT) return Button.BUTTON_LEFT
        if(key == BUTTON_RIGHT) return Button.BUTTON_RIGHT
        if(key == BUTTON_DOWN) return Button.BUTTON_DOWN

        return Button.NO_BUTTON
    }
}