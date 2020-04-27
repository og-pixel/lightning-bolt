package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.Button.NO_BUTTON
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.display.MainWindow
import com.miloszjakubanis.gameEngine.layer.BoardLayer
import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.levels.DebugLevel
import com.miloszjakubanis.gameEngine.levels.GameLevel
import com.miloszjakubanis.gameEngine.renderer.Renderer
import com.miloszjakubanis.gameEngine.renderer.StandardRenderer
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

//        var allObjects: List<GameObject> = ArrayList()

        //TODO this will be instead of all objects
        var currentLevel: Int = 0
        var levelList: MutableList<GameLevel> = ArrayList()
    }

    private val renderer: Renderer = StandardRenderer()
//    val gameLayer: GameLayer
    val input: Input = DefaultInput()

    var pressedButton: Button = NO_BUTTON
    var mainWindow: MainWindow = MainWindow(this, input)

    init {
        levelList.add(DebugLevel())
    }

    private fun tick() {
        takeUserInput()
        updateAnimation()
    }

    private fun takeUserInput() {
        if (pressedButton != NO_BUTTON) {
//            player.readInput(pressedButton)
            pressedButton = NO_BUTTON
        }
    }

    private fun updateAnimation() {
        levelList[currentLevel].visibleObjects.forEach { e ->
            e.objectSprites?.getCurrentAnimation()?.nextFrame()
        }
    }

    private fun redrawCanvas() {
        clearCanvas()
        val graphicsContext = mainWindow.controller.graphicsContext

        //TODO this should render board etc
        renderer.renderVisible()

        levelList[currentLevel].visibleObjects.forEach { e ->
            graphicsContext.drawImage(e.objectSprites?.getCurrentAnimation()?.currentSprite?.image, e.xPos, e.yPos)
        }

    }

    private fun clearCanvas() {
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
            Thread.sleep(7)

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