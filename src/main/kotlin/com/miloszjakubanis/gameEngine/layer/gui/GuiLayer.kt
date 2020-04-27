package com.miloszjakubanis.gameEngine.layer.gui

import com.miloszjakubanis.gameEngine.layer.Layer

interface GuiLayer : Layer {
    override val layerWidth: Int
    override val layerHeight: Int
}