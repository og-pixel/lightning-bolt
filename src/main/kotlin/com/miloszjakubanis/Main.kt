package com.miloszjakubanis

import javafx.application.Application
import javafx.stage.Stage

class Main : Application() {
    override fun start(primaryStage: Stage) {
        val gameLoop = GameFactory.createGameLoop(LoopType.Basic)
        Thread(gameLoop).start()

    }
}

fun main(args: Array<String>){
    Application.launch(Main::class.java, *args)
}