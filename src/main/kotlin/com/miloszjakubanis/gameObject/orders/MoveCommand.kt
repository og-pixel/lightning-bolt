package com.miloszjakubanis.gameObject.orders

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
        val manhatannDistance =
            abs(destinationPosition.xPos - gameObject.xPos) + abs(destinationPosition.yPos - gameObject.yPos)
        findLowest()

    }

    override fun removeCommand() {
    }

    //TODO this is more than silly, but it works so its fine as a proof of concept
    private fun findLowest(){
        val manhatannDistanceRight =
            abs(destinationPosition.xPos - (gameObject.xPos + 1)) + abs(destinationPosition.yPos - gameObject.yPos)

        val manhatannDistanceLeft =
            abs(destinationPosition.xPos - (gameObject.xPos - 1)) + abs(destinationPosition.yPos - gameObject.yPos)

        val manhatannDistanceDown =
            abs(destinationPosition.xPos - (gameObject.xPos)) + abs(destinationPosition.yPos - (gameObject.yPos + 1))

        val manhatannDistanceUp =
            abs(destinationPosition.xPos - (gameObject.xPos)) + abs(destinationPosition.yPos - (gameObject.yPos - 1))


        val arr = ArrayList<Double>()
        arr.add(manhatannDistanceRight)
        arr.add(manhatannDistanceLeft)
        arr.add(manhatannDistanceDown)
        arr.add(manhatannDistanceUp)
        arr.indexOf(Collections.min(arr))

        if(manhatannDistanceDown <= manhatannDistanceLeft &&
                manhatannDistanceDown <= manhatannDistanceRight &&
                manhatannDistanceDown <= manhatannDistanceUp){
            gameObject.moveDown()
        }
        else if( manhatannDistanceLeft <= manhatannDistanceDown &&
            manhatannDistanceLeft <= manhatannDistanceRight &&
            manhatannDistanceLeft <= manhatannDistanceUp){
            gameObject.moveLeft()
        }
        else if( manhatannDistanceRight <= manhatannDistanceLeft &&
            manhatannDistanceRight <= manhatannDistanceDown &&
            manhatannDistanceRight <= manhatannDistanceUp){
            gameObject.moveRight()
        }
        else if( manhatannDistanceUp <= manhatannDistanceLeft &&
            manhatannDistanceUp <= manhatannDistanceRight &&
            manhatannDistanceUp <= manhatannDistanceDown){
            gameObject.moveUp()
        }
        else print("twat ")

        if (isCloseEnough()) gameObject.commandList.removeCommand()

    }

    //TODO method to make sure object is close enough on the board
    fun isCloseEnough(): Boolean {
        val manhatannDistance =
            abs(destinationPosition.xPos - gameObject.xPos) + abs(destinationPosition.yPos - gameObject.yPos)
        return manhatannDistance <= 0.8
    }

}