package com.miloszjakubanis.gameEngine

import com.miloszjakubanis.controls.Button.*
import com.miloszjakubanis.controls.Button
import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.display.MainWindow
import com.miloszjakubanis.gameEngine.board.GameLayer
import com.miloszjakubanis.gameEngine.board.BoardLayer
import com.miloszjakubanis.gameEngine.board.GroundTile
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player
import com.miloszjakubanis.gameObject.spriteGraphics.AnimationDirection
import com.miloszjakubanis.gameObject.spriteGraphics.SpriteFactory
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

    val gameLayer: GameLayer

    init {
        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var downIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_4.png")
            .addFrame("sprites/characters/soldier/sprite_5.png")
            .addFrame("sprites/characters/soldier/sprite_6.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.DOWN)

        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var rightIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_1.png")
            .addFrame("sprites/characters/soldier/sprite_2.png")
            .addFrame("sprites/characters/soldier/sprite_3.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.RIGHT)

        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var upIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_7.png")
            .addFrame("sprites/characters/soldier/sprite_8.png")
            .addFrame("sprites/characters/soldier/sprite_9.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.UP)

        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var leftIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_10.png")
            .addFrame("sprites/characters/soldier/sprite_11.png")
            .addFrame("sprites/characters/soldier/sprite_12.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.LEFT)

        player = Player(70.0, 200.0, speed = 300.0)
        player.objectSprites?.addAnimation(downIdleAnimation)
        player.objectSprites?.addAnimation(rightIdleAnimation)
        player.objectSprites?.addAnimation(upIdleAnimation)
        player.objectSprites?.addAnimation(leftIdleAnimation)

        allObjects = allObjects + player

        gameLayer = BoardLayer(10,10, 50.0, 50.0)
        //TODO remove
//        System.exit(0)
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


        for (x in 0..gameLayer.boardHeight){
            for (y in 0..gameLayer.boardWidth){
                val tileImage = gameLayer.getTile(x,y).spriteFrame.image
                val tileImage2 = (gameLayer.getTile(x,y) as GroundTile).spriteFrame2.image

                if(gameLayer.getTile(x,y).isFocused){
                    graphicsContext.drawImage(tileImage2, x * 50.0,y * 50.0)
                }else{
                    graphicsContext.drawImage(tileImage, x * 50.0,y * 50.0)
                }

            }
        }

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