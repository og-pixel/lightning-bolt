package com.miloszjakubanis.gameObject.sound

import java.util.*

class BasicSound: SoundSource {

    val x: Map<SoundType, List<String>> = EnumMap(SoundType::class.java)

    override fun getSoundList(): Map<SoundType, List<String>> {
        return x
    }

//    override val soundList: Map<SoundType, List<String>>
//        get() = x

    override fun playSound(duration: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopSound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllSoundsBasedOnType(soundType: SoundType): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}