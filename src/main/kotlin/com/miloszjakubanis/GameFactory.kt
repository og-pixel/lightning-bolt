package com.miloszjakubanis

import com.miloszjakubanis.gameEngine.GameLoop
import java.lang.RuntimeException

enum class LoopType{
    Basic
}

object GameFactory {
    fun createGameLoop(loopType: LoopType): GameLoop {

        if(loopType == LoopType.Basic) return GameLoop()
        else throw RuntimeException("Wrong Choice of game loop")
    }
}
