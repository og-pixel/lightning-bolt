package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.Button.NO_BUTTON
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.gameDisplay.MainWindow
import com.miloszjakubanis.gameEngine.levels.DebugLevel
import com.miloszjakubanis.gameEngine.levels.GameLevel
import com.miloszjakubanis.gameEngine.renderer.Renderer
import com.miloszjakubanis.gameEngine.renderer.StandardRenderer
import javafx.application.Platform

class GameLoop : Runnable {

    //Additional information used to see at what tick the game is on etc
    companion object {
        const val ticksPerSecond = 60
        const val oneFrameDuration = 1000000000 / ticksPerSecond
        var currentTick = 0
            private set

        var currentFrame = 0
            private set

        var gameStatus: LoopStatus = LoopStatus.STOPPED
            private set

        var currentLevelIndex: Int = 0
            private set

        var levelList: MutableList<GameLevel> = ArrayList()

        val currentLevel: GameLevel
            get() = levelList[currentLevelIndex]

        init {
            levelList.add(DebugLevel())
        }
    }

    //User's Input
    val gameInput: Input = DefaultInput()

    //Main Window Game is displaying on
    var mainWindow: MainWindow = MainWindow(this, gameInput)

    //What Button user is pressing, might be removed to be done differently later
    var pressedButton: Button = NO_BUTTON

    //Renderer takes graphics context from window controller to draw with
    //Layers to render (mostly from a currently played level)
    //TODO change signature
    private val renderer: Renderer = StandardRenderer(
        mainWindow.controller.graphicsContext,
        levelList[currentLevelIndex].listGameLayers,
        currentLevel
    )

    private fun tick() {
        takeUserInput()
        updateAnimation()
    }

    //TODO at some point work on it,
    // it needs to be more sophisticated
    private fun takeUserInput() {
        if (pressedButton != NO_BUTTON) {
            levelList[currentLevelIndex].playerObject.readInput(pressedButton)
            pressedButton = NO_BUTTON
        }
    }

    /**
     * Get all objects from the current level and perform their next
     * animation (logic?) tick
     */
    private fun updateAnimation() {
        currentLevel.gameTick()
    }

    /**
     * Uses defined renderer to clear canvas and redraw
     * game window
     */
    private fun redrawCanvas() {
        renderer.clearCanvas()
        //TODO render Layers is not used at the moment, I only render visible
        renderer.renderLayers()
        renderer.renderVisibleObjects()
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