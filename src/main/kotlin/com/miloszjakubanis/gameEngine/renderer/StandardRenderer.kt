package com.miloszjakubanis.gameEngine.renderer

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.layer.ObjectVisibility
import com.miloszjakubanis.gameEngine.levels.GameLevel
import javafx.scene.canvas.GraphicsContext

class StandardRenderer(
    override val graphicsContext: GraphicsContext,
    override val layerList: List<GameLayer>,
    override val currentLevel: GameLevel
) : Renderer {

    override fun renderLayer(layer: GameLayer) {
        TODO()
    }

    /**
     *  Performs one tick's worth of animation
     */
    override fun renderVisibleObjects() {
        currentLevel.allObjects[ObjectVisibility.VISIBLE]?.forEach { e ->
            graphicsContext.drawImage(e.objectSprites?.currentAnimation?.currentSprite?.image, e.xPos, e.yPos)
        }
    }
}