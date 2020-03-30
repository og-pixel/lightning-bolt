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

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        graphicsContext = mainCanvas.graphicsContext2D
    }

}