package com.miloszjakubanis.display

import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.gameEngine.GameLoop
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.input.KeyEvent
import javafx.stage.Stage

class MainWindow(
    private val gameLoop: GameLoop,
    private val input: Input
) : Runnable {

    private val fxmlLoader = FXMLLoader()
    private val root: Parent = fxmlLoader.load(this::class.java.getResource("/MainView.fxml").openStream())
    val controller: MainController = fxmlLoader.getController()

    init {
        addInputListeners()
    }

    private fun addInputListeners() {
        val eventHandler: EventHandler<KeyEvent> = EventHandler { event ->
            gameLoop.pressedButton = input.getKeyPressed(event.text)
        }
        controller.pane.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler)
    }

    override fun run() {
        val stage = Stage()
        stage.scene = Scene(root, 800.0, 600.0)
        stage.title = "Main Window"
        stage.show()
    }
}