package com.miloszjakubanis.gameDisplay

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.orders.MoveCommand
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import java.net.URL
import java.util.*
import com.miloszjakubanis.gameObject.Position

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

    fun addEventListener() {




        val mouseEvent: EventHandler<MouseEvent> = EventHandler { event ->
            //TODO slighlty bad and hardcoded
            val height = GameLoop.currentLevel.gameLayers[0].tileHeight
            val width = GameLoop.currentLevel.gameLayers[0].tileWidth

            val xPos: Int = (event.x / width).toInt()
            val yPos: Int = (event.y / height).toInt()
            val tile = GameLoop.currentLevel.gameLayers[0].getTile(xPos, yPos)

            tile.isFocused = !tile.isFocused

//            GameLoop.currentLevel.
            //TODO extract this part
//            println("x:" + (GameLoop.currentLevel.playerObject.xPos / width).toInt() + "\n"+
//                    "y:" + (GameLoop.currentLevel.playerObject.yPos / height).toInt())


            val pos: Position = Position(xPos.toDouble() * width, yPos.toDouble() * height)
            val player = GameLoop.currentLevel.playerObject
            GameLoop.currentLevel.playerObject.commandList.addCommand(MoveCommand(player, pos))



        }
        mainCanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent)

    }

}