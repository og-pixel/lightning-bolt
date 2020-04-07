package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.display.MainWindow
import com.miloszjakubanis.gameObject.BasicObject
import com.miloszjakubanis.gameObject.`object`.Character
import com.miloszjakubanis.gameObject.graphics.Frame
import com.miloszjakubanis.gameObject.`object`.Player
import com.miloszjakubanis.gameObject.graphics.Animation
import com.miloszjakubanis.gameObject.graphics.AnimationFactory
import javafx.application.Platform
import javafx.scene.image.Image
import java.util.function.Consumer

class GameLoop : Runnable {

    companion object {
        val ticksPerSecond = 60
        val oneFrameDuration = 1000000000 / ticksPerSecond
        var currentTick = 0
            private set

        var currentFrame = 0
            private set

        var gameStatus: LoopStatus = LoopStatus.STOPPED
            private set

        var allObjects: List<BasicObject> = ArrayList()
    }


    //TODO should be init somehow differently
    private val controllable: Player

    init {
        AnimationFactory.height = 30.0
        AnimationFactory.width = 30.0
        AnimationFactory.scale = 4.0
        AnimationFactory.animationSpeed = 1
        AnimationFactory.addFrame("sprites/soldier/sprite_4.png")
        AnimationFactory.addFrame("sprites/soldier/sprite_5.png")
        AnimationFactory.addFrame("sprites/soldier/sprite_6.png")

        var animation = AnimationFactory.getAnimation()
        controllable = Player(70.0, 200.0, animation, speed = 999.0)

        for (x in 0..100) {
            AnimationFactory.height = 30.0
            AnimationFactory.width = 30.0
            AnimationFactory.scale = 4.0
            AnimationFactory.addFrame("sprites/soldier/sprite_4.png")
            AnimationFactory.addFrame("sprites/soldier/sprite_5.png")
            AnimationFactory.addFrame("sprites/soldier/sprite_6.png")
            var animation2 = AnimationFactory.getAnimation()
            allObjects = allObjects + Character((x * 25.0), (0.0), animation2)
        }
    }

    var pressedButton: Button = NO_BUTTON

    val input: Input = DefaultInput()
    var mainWindow: MainWindow =
        MainWindow(this, input)

    private fun tick() {
        takeUserInput()
        updateAnimation()
    }

    private fun takeUserInput() {
        if (pressedButton != NO_BUTTON) {
            controllable.readInput(pressedButton)
            pressedButton = NO_BUTTON
        }
    }

    private fun updateAnimation() {
        allObjects.forEach { e -> e.animation.nextFrame() }
        controllable.animation.nextFrame()
    }

    private fun redrawCanvas() {
        val width = mainWindow.controller.mainCanvas.width
        val height = mainWindow.controller.mainCanvas.height
        val graphicsContext = mainWindow.controller.graphicsContext
        graphicsContext.clearRect(0.0, 0.0, width, height)

        graphicsContext.drawImage(controllable.animation.currentSprite.image, controllable.xPos, controllable.yPos)
        allObjects.forEach { e ->
            graphicsContext.drawImage(e.animation.currentSprite.image, e.xPos, e.yPos)
        }
    }

    override fun run() {
        createWindow()
        startLoop()
    }

    private fun createWindow() {
        Platform.runLater(mainWindow)
    }

    private fun startLoop() {
        gameStatus = LoopStatus.RUNNING

        var lastTime = System.nanoTime()
        var delta = 0.0
        var timer = System.currentTimeMillis()

        while (gameStatus == LoopStatus.RUNNING) {
            Thread.sleep(3)

            val now = System.nanoTime()
            delta += (now - lastTime) / oneFrameDuration.toDouble()
            lastTime = now
            if (delta >= 1) {
                tick()
//                redrawCanvas()
                currentTick++
                delta--
            }
            redrawCanvas()
            currentFrame++

            //Update every second
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000
                println("$currentTick Ticks, Fps $currentFrame")
                currentTick = 0
                currentFrame = 0
            }
        }
    }
}