package com.miloszjakubanis.gameEngine.objectFactory

import com.miloszjakubanis.gameEngine.levels.GameLevel
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.EnvironmentObject
import com.miloszjakubanis.gameObject.`object`.Player

interface ObjectFactory {

    val currentLevel: GameLevel

    fun createPlayerObject(): Player

    fun createGameObject(): GameObject

    fun createEnvironmentObject(): EnvironmentObject
}