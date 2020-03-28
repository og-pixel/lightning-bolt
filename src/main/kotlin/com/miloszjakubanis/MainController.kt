package com.miloszjakubanis

import com.miloszjakubanis.controls.DefaultInput
import com.miloszjakubanis.controls.Input
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.image.Image
import javafx.scene.input.KeyEvent
import javafx.scene.layout.AnchorPane
import java.io.FileInputStream
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
    val loop: GameLoop = GameFactory.createGameLoop(LoopType.Basic)
    val input: Input = DefaultInput()

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        graphicsContext = mainCanvas.graphicsContext2D
        graphicsContext.drawImage(Image("img/1.jpg"), 10.0, 10.0, 50.0, 50.0)

        addInput()
    }
    init {
//        input.attach(loop)


        Thread(loop).start()
    }

    fun addInput(){
        val x: EventHandler<KeyEvent> = EventHandler { event ->
            loop.pressedButton = input.getKeyPressed(event.text)
        }
        pane.addEventHandler(KeyEvent.KEY_PRESSED, x)
    }
}