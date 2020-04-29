package com.miloszjakubanis.gameEngine.levels

import com.miloszjakubanis.gameEngine.layer.BoardLayer
import com.miloszjakubanis.gameObject.Position
import com.miloszjakubanis.gameEngine.layer.GameLayer
import com.miloszjakubanis.gameEngine.layer.ObjectVisibility
import com.miloszjakubanis.gameEngine.layer.gui.GuiLayer
import com.miloszjakubanis.gameEngine.objectFactory.DebugObjectFactory
import com.miloszjakubanis.gameEngine.objectFactory.ObjectFactory
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player
import com.miloszjakubanis.gameObject.orders.MoveCommand
import com.miloszjakubanis.gameObject.sprite.AnimationDirection
import com.miloszjakubanis.gameObject.sprite.AnimationStance
import com.miloszjakubanis.gameObject.sprite.SpriteFactory
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DebugLevel(
    override var allObjects: HashMap<ObjectVisibility, MutableList<GameObject>> = HashMap()
) : GameLevel {

    override val playerObject: Player
    override val objectFactory: ObjectFactory

    override var guiLayer: GuiLayer
        get() = TODO()
        set(value) {}

    override var gameLayers: MutableList<GameLayer> = ArrayList()

    init {
        objectFactory = DebugObjectFactory(this)

        SpriteFactory.height = 16.0
        SpriteFactory.width = 16.0
        SpriteFactory.scale = 2.0
        SpriteFactory.animationSpeed = 1
        var downIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_4.png")
            .addFrame("sprites/characters/soldier/sprite_5.png")
            .addFrame("sprites/characters/soldier/sprite_6.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.DOWN)

        SpriteFactory.height = 16.0
        SpriteFactory.width = 16.0
        SpriteFactory.scale = 2.0
        SpriteFactory.animationSpeed = 1
        var rightIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_1.png")
            .addFrame("sprites/characters/soldier/sprite_2.png")
            .addFrame("sprites/characters/soldier/sprite_3.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.RIGHT )

        SpriteFactory.height = 16.0
        SpriteFactory.width = 16.0
        SpriteFactory.scale = 2.0
        SpriteFactory.animationSpeed = 1
        var upIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_7.png")
            .addFrame("sprites/characters/soldier/sprite_8.png")
            .addFrame("sprites/characters/soldier/sprite_9.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.UP)

        SpriteFactory.height = 16.0
        SpriteFactory.width = 16.0
        SpriteFactory.scale = 2.0
        SpriteFactory.animationSpeed = 1
        var leftIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_10.png")
            .addFrame("sprites/characters/soldier/sprite_11.png")
            .addFrame("sprites/characters/soldier/sprite_12.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.LEFT)

        playerObject = Player(Position(0.0, 0.0), speed = 100.0)
        playerObject.objectSprites?.addAnimation(downIdleAnimation)
        playerObject.objectSprites?.addAnimation(rightIdleAnimation)
        playerObject.objectSprites?.addAnimation(upIdleAnimation)
        playerObject.objectSprites?.addAnimation(leftIdleAnimation)

        for (visibility in ObjectVisibility.values()) {
            allObjects[visibility] = ArrayList()
        }
//        playerObject.commandList.addCommand(MoveCommand(playerObject, Position(500.0, 500.0)))
        allObjects[ObjectVisibility.VISIBLE]!!.add(playerObject)

        val boardLayer = BoardLayer(10, 5, 64.0, 64.0)
        gameLayers.add(boardLayer)
    }
}