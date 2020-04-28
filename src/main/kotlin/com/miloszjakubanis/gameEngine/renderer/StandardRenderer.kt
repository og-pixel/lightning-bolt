package com.miloszjakubanis.gameEngine.renderer

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.layer.ObjectVisibility
import javafx.scene.canvas.GraphicsContext

class StandardRenderer(
    override val graphicsContext: GraphicsContext,
    override val layerList: List<GameLayer>
) : Renderer {

    override fun renderLayer(layer: GameLayer) {
        TODO()
    }

    override fun renderVisibleObjects() {
        GameLoop.currentLevel.allObjects[ObjectVisibility.VISIBLE]?.forEach { e ->
            graphicsContext.drawImage(e.objectSprites?.currentAnimation?.currentSprite?.image, e.xPos, e.yPos)
        }

        GameLoop.currentLevel.allObjects[ObjectVisibility.NOT_VISIBLE]?.forEach { e ->
            graphicsContext.drawImage(e.objectSprites?.currentAnimation?.currentSprite?.image, e.xPos, e.yPos)
        }
    }
}