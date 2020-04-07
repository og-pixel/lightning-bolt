package com.miloszjakubanis.gameEngine.board

interface GameBoard {

    val layerList: List<Layer>

    fun getFrontLayer(): Layer {
        return layerList[0]
    }

    fun getLastLayer(): Layer {
        return layerList[layerList.size]
    }
}