package com.miloszjakubanis.gameEngine.renderer

import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.layer.ObjectVisibility
import com.miloszjakubanis.gameEngine.levels.GameLevel
import javafx.scene.canvas.GraphicsContext

class StandardRenderer(
    override val graphicsContext: GraphicsContext,
    override val currentLevel: GameLevel
) : Renderer {

    override fun renderLayer(layer: GameLayer) {
        val tileWidth: Double = layer.tileWidth
        val tileHeight: Double = layer.tileHeight

        for (y in 0 until layer.numberOfRows) {
            for (x in 0 until layer.numberOfColumns) {
                graphicsContext.drawImage(layer.getTile(x, y).getFrame().image, x * tileWidth, y * tileHeight)
            }
        }
    }

    /**
     *  Performs one tick's worth of animation
     */
    override fun renderVisibleObjects() {
        currentLevel.allObjects[ObjectVisibility.VISIBLE]!!.forEach { e ->
            val xPos =  e.xPos - (e.objectSprites!!.getWidth / 2)
            val yPos = e.yPos - (e.objectSprites!!.getHeight / 2)


            graphicsContext.drawImage(e.objectSprites!!.currentAnimation.currentSprite.image, xPos, yPos)
        }
    }
}