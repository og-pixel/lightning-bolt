package com.miloszjakubanis.gameEngine.objectFactory

import com.miloszjakubanis.gameEngine.levels.GameLevel
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.EnvironmentObject
import com.miloszjakubanis.gameObject.`object`.Player

class DebugObjectFactory(
    override val currentLevel: GameLevel
) : ObjectFactory {

    override fun createPlayerObject(): Player {
        TODO("Not yet implemented")
    }

    override fun createGameObject(): GameObject {
        TODO("Not yet implemented")
    }

    override fun createEnvironmentObject(): EnvironmentObject {
        TODO("Not yet implemented")
    }
   
}