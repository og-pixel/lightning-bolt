package com.miloszjakubanis.gameObject.hitbox

interface HitBox {
    var width: Int
    var height: Int

//    var isHit: Boolean

    fun checkHitbox(): Boolean
}