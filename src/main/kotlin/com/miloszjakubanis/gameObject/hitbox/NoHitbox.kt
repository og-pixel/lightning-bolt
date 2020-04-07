package com.miloszjakubanis.gameObject.hitbox

import com.miloszjakubanis.gameObject.hitbox.HitBox

//TODO i think this is a stupid idea
class NoHitbox: HitBox {
    override var width: Int
        get() = 0
        set(value) {}
    override var height: Int
        get() = 0
        set(value) {}

    override fun checkHitbox(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}