package com.miloszjakubanis.unit.sound

interface SoundSource {

    //TODO realistically, it should hold a list of files
    // or something similar as a sound source
    val soundList: Map<SoundType, List<String>>

    fun playSound(duration: Double)
    fun stopSound()

    fun getAllSoundsBasedOnType(soundType: SoundType)
}