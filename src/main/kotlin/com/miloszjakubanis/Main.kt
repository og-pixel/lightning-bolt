package com.miloszjakubanis

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/MainView.fxml"))
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root, 800.0, 600.0)
        primaryStage.show()
    }
}

fun main(args: Array<String>){
    Application.launch(Main::class.java, *args)
}