package com.miloszjakubanis.gameObject.artificialIntelligence

import com.miloszjakubanis.gameObject.GameObject

interface Decision {

    fun performDecision(gameObject: GameObject)
}