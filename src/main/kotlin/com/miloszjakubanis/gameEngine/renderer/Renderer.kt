package com.miloszjakubanis.gameEngine.renderer

import com.miloszjakubanis.gameEngine.layer.GameLayer
import javafx.scene.canvas.GraphicsContext

interface Renderer {

    val graphicsContext: GraphicsContext

    val layerList: List<GameLayer>

    fun renderLayer(layer: GameLayer)

    fun renderVisibleObjects()

    //TODO make sure it renders in right order
    fun renderLayers() {
        for (layer in layerList) renderLayer(layer)
    }

    fun clearCanvas() {
        val width = graphicsContext.canvas.width
        val height = graphicsContext.canvas.height
        graphicsContext.clearRect(0.0, 0.0, width, height)
    }
}