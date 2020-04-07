package com.miloszjakubanis.gameObject.artificialIntelligence

import com.miloszjakubanis.gameObject.BasicObject

interface Decision {

    fun performDecision(basicObject: BasicObject)
}