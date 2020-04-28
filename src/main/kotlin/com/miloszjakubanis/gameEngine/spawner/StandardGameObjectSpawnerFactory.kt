package com.miloszjakubanis.gameEngine.spawner

import com.miloszjakubanis.gameEngine.levels.GameLevel
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player

class StandardGameObjectSpawnerFactory(
    override val currentLevel: GameLevel
) : ObjectSpawnerFactory {

    override fun createPlayerObject(): Player {
        TODO("Not yet implemented")
    }

    override fun createGameObject(): GameObject {
        TODO("Not yet implemented")
    }
}