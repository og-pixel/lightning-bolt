package com.miloszjakubanis.gameObject.orders

import com.miloszjakubanis.gameObject.GameObject

class RegularCommand(
    override val gameObject: GameObject
) : Command {

    override fun executeCommand() {
        gameObject.moveDown()
    }

}