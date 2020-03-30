package com.miloszjakubanis.unit

//TODO i think this is a stupid idea
class NoHitbox: HitBox {
    override var width: Int
        get() = 0
        set(value) {}
    override var height: Int
        get() = 0
        set(value) {}
}