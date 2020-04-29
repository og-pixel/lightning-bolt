package com.miloszjakubanis.gameObject.orders

import com.miloszjakubanis.gameEngine.GameLoop
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.Position
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class MoveCommand(
    override val gameObject: GameObject,
    val destinationPosition: Position
) : Command {

    override fun executeCommand() {
//        val manhatannDistance =
//            abs(destinationPosition.xPos - gameObject.xPos) + abs(destinationPosition.yPos - gameObject.yPos)
        findLowest()

    }

    override fun removeCommand() {
    }

    val tileHeight: Int = (GameLoop.currentLevel.gameLayers[0].tileHeight / 2).toInt()
    val tileWidth: Int = (GameLoop.currentLevel.gameLayers[0].tileWidth / 2).toInt()

    //TODO this is more than silly, but it works so its fine as a proof of concept
    private fun findLowest() {


        val manhatannDistanceRight =
            abs(destinationPosition.xPos + tileWidth - (gameObject.xPos + 1)) + abs(destinationPosition.yPos + tileHeight - gameObject.yPos)

        val manhatannDistanceLeft =
            abs(destinationPosition.xPos + tileWidth - (gameObject.xPos - 1)) + abs(destinationPosition.yPos + tileHeight - gameObject.yPos)

        val manhatannDistanceDown =
            abs(destinationPosition.xPos + tileWidth - (gameObject.xPos)) + abs(destinationPosition.yPos + tileHeight - (gameObject.yPos + 1))

        val manhatannDistanceUp =
            abs(destinationPosition.xPos + tileWidth - (gameObject.xPos)) + abs(destinationPosition.yPos + tileHeight - (gameObject.yPos - 1))



        if (manhatannDistanceDown <= manhatannDistanceLeft &&
            manhatannDistanceDown <= manhatannDistanceRight &&
            manhatannDistanceDown <= manhatannDistanceUp
        ) {
            gameObject.moveDown()
        } else if (manhatannDistanceLeft <= manhatannDistanceDown &&
            manhatannDistanceLeft <= manhatannDistanceRight &&
            manhatannDistanceLeft <= manhatannDistanceUp
        ) {
            gameObject.moveLeft()
        } else if (manhatannDistanceRight <= manhatannDistanceLeft &&
            manhatannDistanceRight <= manhatannDistanceDown &&
            manhatannDistanceRight <= manhatannDistanceUp
        ) {
            gameObject.moveRight()
        } else if (manhatannDistanceUp <= manhatannDistanceLeft &&
            manhatannDistanceUp <= manhatannDistanceRight &&
            manhatannDistanceUp <= manhatannDistanceDown
        ) {
            gameObject.moveUp()
        } else print("twat ")

        if (isCloseEnough()) gameObject.commandList.removeCommand()

    }

    //TODO method to make sure object is close enough on the board
    fun isCloseEnough(): Boolean {
        val manhatannDistance =
            abs(destinationPosition.xPos + tileWidth  - gameObject.xPos) + abs(destinationPosition.yPos + tileHeight - gameObject.yPos)
        return manhatannDistance <= 1.5
    }

}