package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.display.MainWindow
import com.miloszjakubanis.gameObject.BasicObject
import com.miloszjakubanis.gameObject.`object`.Character
import com.miloszjakubanis.gameObject.`object`.Player
import com.miloszjakubanis.gameObject.spriteGraphics.GameSprite
//import com.miloszjakubanis.gameObject.spriteGraphics.AnimationDirection
//import com.miloszjakubanis.gameObject.spriteGraphics.AnimationFactory
//import com.miloszjakubanis.gameObject.spriteGraphics.AnimationStance
import com.miloszjakubanis.gameObject.spriteGraphics.GameSprite.AnimationFactory
import javafx.application.Platform

class GameLoop : Runnable {

    companion object {
        const val ticksPerSecond = 60
        const val oneFrameDuration = 1000000000 / ticksPerSecond
        var currentTick = 0
            private set

        var currentFrame = 0
            private set

        var gameStatus: LoopStatus = LoopStatus.STOPPED
            private set

        var allObjects: List<BasicObject> = ArrayList()
    }

    //TODO should be init somehow differently
    private val player: Player

    init {
        AnimationFactory.height = 30.0
        AnimationFactory.width = 30.0
        AnimationFactory.scale = 4.0
        AnimationFactory.animationSpeed = 1
        var animation = AnimationFactory.addFrame("sprites/soldier/sprite_4.png")
            .addFrame("sprites/soldier/sprite_5.png")
            .addFrame("sprites/soldier/sprite_6.png")
            .getAnimation(GameSprite.AnimationStance.IDLE, GameSprite.AnimationDirection.DOWN)
//        var animation = AnimationFactory.getAnimation()
        player = Player(70.0, 200.0, GameSprite(), speed = 80.0)
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
            player.readInput(pressedButton)
            pressedButton = NO_BUTTON
        }
    }

    private fun updateAnimation() {
        //TODO put animation back
//        allObjects.forEach { e -> e.spriteAnimation.nextFrame() }
//        player.spriteAnimation?.nextFrame()
//        player.gameSprite?.getAnimation(AnimationDirection.DOWN, AnimationStance.IDLE).
    }

    private fun redrawCanvas() {
        val width = mainWindow.controller.mainCanvas.width
        val height = mainWindow.controller.mainCanvas.height
        val graphicsContext = mainWindow.controller.graphicsContext
        graphicsContext.clearRect(0.0, 0.0, width, height)

//        graphicsContext.drawImage(player.spriteAnimation?.currentSprite?.image, player.xPos, player.yPos)
//        allObjects.forEach { e ->
//            graphicsContext.drawImage(e.spriteAnimation?.currentSprite?.image, e.xPos, e.yPos)
//        }
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
            Thread.sleep(6)

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