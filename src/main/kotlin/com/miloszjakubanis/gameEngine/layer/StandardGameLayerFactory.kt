package com.miloszjakubanis.gameEngine.layer

class StandardGameLayerFactory : LayerFactory {

    override fun createLayer(): BoardLayer {
        val gameLayer = BoardLayer(
            20, 20,
            5.0, 5.0
        )

        return gameLayer
    }
}