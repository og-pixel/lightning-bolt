package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.graphics.Sprite
import com.miloszjakubanis.unit.BasicObject
import com.miloszjakubanis.unit.Controllable
import com.miloszjakubanis.unit.Player
import javafx.application.Platform
import javafx.scene.paint.Paint

class GameLoop: Runnable {

    val ticksPerSecond = 60
    val oneFrameDuration = 1000000000 / ticksPerSecond
    var gameStatus: LoopStatus = LoopStatus.STOPPED
    private set

    //TODO should be init somehow differently
    private val controllable: Player = Player(Sprite(100.0, 100.0))

    var pressedButton: Button = NO_BUTTON

    val input: Input = DefaultInput()
    var mainWindowInterface: MainWindowInterface = MainWindowInterface(this, input)

    private fun tick() {
        takeUserInput()
    }

    private fun takeUserInput() {
//        controllable.readInput(BUTTON_DOWN)

        if(pressedButton != NO_BUTTON){
            controllable.readInput(pressedButton)
            pressedButton = NO_BUTTON
        }
    }

    private fun redrawCanvas() {
        val width = mainWindowInterface.controller.mainCanvas.width
        val height = mainWindowInterface.controller.mainCanvas.height
        val graphicsContext = mainWindowInterface.controller.graphicsContext
        graphicsContext.clearRect(0.0, 0.0, width, height)
        graphicsContext.drawImage(controllable.sprite.image, controllable.xPos, controllable.yPos)
    }

    override fun run() {
        createWindow()
        startLoop()
    }

    private fun createWindow(){
        Platform.runLater(mainWindowInterface)
    }

    private fun startLoop() {
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
                redrawCanvas()
                updates++
                delta--
            }
//            redrawCanvas()
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
}