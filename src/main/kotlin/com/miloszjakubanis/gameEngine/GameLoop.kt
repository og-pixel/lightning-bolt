package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.unit.Controllable
import com.miloszjakubanis.unit.Player

class GameLoop: Runnable {

    private val ticksPerSecond = 60
    private val oneFrameDuration = 1000000000 / ticksPerSecond

    private var gameStatus: LoopStatus = LoopStatus.STOPPED

    //TODO should be init somehow differently
    private val controllable: Controllable = Player()

    var pressedButton: Button = NO_BUTTON

    fun startLoop() {
        gameStatus = LoopStatus.RUNNING

        var lastTime = System.nanoTime()
        var delta = 0.0
        var updates = 0
        var frames = 0
        var timer = System.currentTimeMillis()

        while (gameStatus == LoopStatus.RUNNING) {
            val now = System.nanoTime()
            delta += (now - lastTime) / oneFrameDuration.toDouble()
            lastTime = now
            if (delta >= 1) {
                tick()
                updates++
                delta--
            }
            redrawCanvas()
            frames++

            //Update every second
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000
                println("$updates Ticks, Fps $frames")
                updates = 0
                frames = 0
            }
        }
    }

    private fun tick() {
        takeUserInput()
    }

    private fun takeUserInput() {
        if(pressedButton != NO_BUTTON){
            println("Pressed: $pressedButton")
            controllable.readInput(pressedButton)
            pressedButton = NO_BUTTON
        }
    }

    private fun redrawCanvas() {
        
    }

    override fun run() {
        startLoop()
    }
}