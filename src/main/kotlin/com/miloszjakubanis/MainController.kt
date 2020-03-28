package com.miloszjakubanis

import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import com.miloszjakubanis.gameEngine.GameLoop
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import javafx.scene.input.KeyEvent
import javafx.scene.layout.AnchorPane
import java.net.URL
import java.util.*

class MainController: Initializable {

    @FXML
    lateinit var mainCanvas: Canvas
    @FXML
    lateinit var graphicsContext: GraphicsContext
    @FXML
    lateinit var pane: AnchorPane

    //TODO those should be init somehow differently
    val gameLoop: GameLoop = GameFactory.createGameLoop(LoopType.Basic)
    val input: Input = DefaultInput()

    private fun addInputListeners(){
        val x: EventHandler<KeyEvent> = EventHandler { event ->
            gameLoop.pressedButton = input.getKeyPressed(event.text)
        }
        pane.addEventHandler(KeyEvent.KEY_PRESSED, x)
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        graphicsContext = mainCanvas.graphicsContext2D
        graphicsContext.drawImage(Image("img/1.jpg"), 50.0, 50.0, 50.0, 50.0)

        addInputListeners()
    }

    //TODO naive, clears whole square
    private fun updateGraphics(){
        graphicsContext.clearRect(0.0, 0.0, mainCanvas.width, mainCanvas.height)
    }

    init {
        Thread(gameLoop).start()
    }
}