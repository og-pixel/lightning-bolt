package com.miloszjakubanis.gameDisplay

import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.gameEngine.GameLoop
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
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
        controller.mainCanvas.isFocusTraversable = true
        controller.mainCanvas.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler)

//        val keyEvent: EventHandler<MouseEvent> = EventHandler { event ->
//        }
//        controller.mainCanvas.addEventHandler(MouseEvent.MOUSE_MOVED, keyEvent)
    }

    override fun run() {
        val stage = Stage()
        stage.scene = Scene(root, 800.0, 600.0)
        stage.title = "Main Window"
        stage.show()
    }
}