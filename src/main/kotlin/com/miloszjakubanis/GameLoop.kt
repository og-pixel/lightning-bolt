package com.miloszjakubanis

import com.miloszjakubanis.controls.ButtonsEnum
import com.miloszjakubanis.controls.Input
import java.awt.event.KeyEvent


class GameLoop: Runnable {
    enum class Status {
        RUNNING,
        STOPPED
    }

//    init {
//        userInput.attach(this)
//    }

    private val TICKS_PER_SECOND = 60
    private val frameTime = 1000000000 / TICKS_PER_SECOND
    private var gameStatus: Status = Status.STOPPED

    //    var pressedButton: String = ""
    var pressedButton: ButtonsEnum? = null

    fun startLoop() {
        gameStatus = Status.RUNNING

        var lastTime = System.nanoTime()
        var delta = 0.0
        var updates = 0
        var frames = 0
        var timer = System.currentTimeMillis()

        while (gameStatus == Status.RUNNING) {
            val now = System.nanoTime()
            delta += (now - lastTime) / frameTime.toDouble()
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
        if(pressedButton != null){
            println("Pressed: $pressedButton")
            pressedButton = null
        }
    }

    private fun redrawCanvas() {
    }

    override fun run() {
        startLoop()
    }
}