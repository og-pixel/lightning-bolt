package com.miloszjakubanis.gameEngine.spawner

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameEngine.levels.GameLevel
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player

interface ObjectSpawnerFactory {

    val currentLevel: GameLevel

    fun createPlayerObject(): Player

    fun createGameObject(): GameObject

}