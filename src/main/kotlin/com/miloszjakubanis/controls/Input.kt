package com.miloszjakubanis.controls

import com.miloszjakubanis.GameLoop
import java.awt.event.KeyEvent

interface Input: Buttons {

//    fun attach(loop: GameLoop)

    fun getKeyPressed(key: String): ButtonsEnum? {
        if(key == BUTTON_1) return ButtonsEnum.BUTTON_1
        if(key == BUTTON_2) return ButtonsEnum.BUTTON_2
        if(key == BUTTON_3) return ButtonsEnum.BUTTON_3
        if(key == BUTTON_4) return ButtonsEnum.BUTTON_4
        if(key == BUTTON_5) return ButtonsEnum.BUTTON_5
        if(key == BUTTON_UP) return ButtonsEnum.BUTTON_UP
        if(key == BUTTON_LEFT) return ButtonsEnum.BUTTON_LEFT
        if(key == BUTTON_RIGHT) return ButtonsEnum.BUTTON_RIGHT
        if(key == BUTTON_DOWN) return ButtonsEnum.BUTTON_DOWN

        return null
    }
}