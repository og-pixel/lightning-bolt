package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.display.MainWindow
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player
import com.miloszjakubanis.gameObject.spriteGraphics.AnimationDirection
import com.miloszjakubanis.gameObject.spriteGraphics.AnimationFactory
import com.miloszjakubanis.gameObject.spriteGraphics.AnimationStance
//import com.miloszjakubanis.gameObject.spriteGraphics.AnimationDirection
//import com.miloszjakubanis.gameObject.spriteGraphics.AnimationFactory
//import com.miloszjakubanis.gameObject.spriteGraphics.AnimationStance
import javafx.application.Platform

class GameLoop : Runnable {

    companion object  {

        const val ticksPerSecond = 60
        const val oneFrameDuration = 1000000000 / ticksPerSecond

        var currentTick = 0
            private set

        var currentFrame = 0
            private set

        var gameStatus: LoopStatus = LoopStatus.STOPPED
            private set

        var allObjects: List<GameObject> = ArrayList()
    }

    //TODO should be init somehow differently
    private val player: Player

    init {
        AnimationFactory.height = 30.0
        AnimationFactory.width = 30.0
        AnimationFactory.scale = 4.0
        AnimationFactory.animationSpeed = 1
        var downIdleAnimation = AnimationFactory.addFrame("sprites/characters/soldier/sprite_4.png")
            .addFrame("sprites/characters/soldier/sprite_5.png")
            .addFrame("sprites/characters/soldier/sprite_6.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.DOWN)

        AnimationFactory.height = 30.0
        AnimationFactory.width = 30.0
        AnimationFactory.scale = 4.0
        AnimationFactory.animationSpeed = 1
        var rightIdleAnimation = AnimationFactory.addFrame("sprites/characters/soldier/sprite_1.png")
            .addFrame("sprites/characters/soldier/sprite_2.png")
            .addFrame("sprites/characters/soldier/sprite_3.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.RIGHT)

        AnimationFactory.height = 30.0
        AnimationFactory.width = 30.0
        AnimationFactory.scale = 4.0
        AnimationFactory.animationSpeed = 1
        var upIdleAnimation = AnimationFactory.addFrame("sprites/characters/soldier/sprite_7.png")
            .addFrame("sprites/characters/soldier/sprite_8.png")
            .addFrame("sprites/characters/soldier/sprite_9.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.UP)

        AnimationFactory.height = 30.0
        AnimationFactory.width = 30.0
        AnimationFactory.scale = 4.0
        AnimationFactory.animationSpeed = 1
        var leftIdleAnimation = AnimationFactory.addFrame("sprites/characters/soldier/sprite_10.png")
            .addFrame("sprites/characters/soldier/sprite_11.png")
            .addFrame("sprites/characters/soldier/sprite_12.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.LEFT)

        player = Player(70.0, 200.0, speed = 300.0)
        player.objectSprites?.addAnimation(downIdleAnimation)
        player.objectSprites?.addAnimation(rightIdleAnimation)
        player.objectSprites?.addAnimation(upIdleAnimation)
        player.objectSprites?.addAnimation(leftIdleAnimation)

        allObjects = allObjects + player
    }

    var pressedButton: Button = NO_BUTTON

    val input: Input = DefaultInput()
    var mainWindow: MainWindow = MainWindow(this, input)

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
        allObjects.forEach { e -> e.objectSprites?.getCurrentAnimation()?.nextFrame() }
    }

    private fun redrawCanvas() {
        clearCanvas()
        val graphicsContext = mainWindow.controller.graphicsContext
        allObjects.forEach { e ->
            graphicsContext.drawImage(e.objectSprites?.getCurrentAnimation()?.currentSprite?.image, e.xPos, e.yPos)
        }
    }

    private fun clearCanvas(){
        val width = mainWindow.controller.mainCanvas.width
        val height = mainWindow.controller.mainCanvas.height
        val graphicsContext = mainWindow.controller.graphicsContext
        graphicsContext.clearRect(0.0, 0.0, width, height)
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