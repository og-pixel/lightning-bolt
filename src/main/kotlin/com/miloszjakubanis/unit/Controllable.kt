package com.miloszjakubanis.unit

import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.graphics.Sprite

/**
 * Classes implementing this interface
 * enter a contract that they will be used
 * as a controllable object by the user
 */
interface Controllable {

    fun readInput(pressedButton: Button)

}