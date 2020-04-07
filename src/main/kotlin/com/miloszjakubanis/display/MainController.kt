package com.miloszjakubanis.display

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
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