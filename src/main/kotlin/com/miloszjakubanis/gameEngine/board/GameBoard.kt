package com.miloszjakubanis.gameEngine.board

interface GameBoard {
    val layerList: List<Layer>


    fun getFrontLayer(): Layer {
        return layerList[0]
    }

}