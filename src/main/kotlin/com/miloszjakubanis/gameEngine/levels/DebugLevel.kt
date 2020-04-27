package com.miloszjakubanis.gameEngine.levels

import com.miloszjakubanis.Position
import com.miloszjakubanis.gameEngine.layer.gui.GuiLayer
import com.miloszjakubanis.gameObject.GameObject
import com.miloszjakubanis.gameObject.`object`.Player
import com.miloszjakubanis.gameObject.sprite.AnimationDirection
import com.miloszjakubanis.gameObject.sprite.AnimationStance
import com.miloszjakubanis.gameObject.sprite.SpriteFactory

class DebugLevel(
    override val visibleObjects: MutableList<GameObject> = ArrayList(),
    override val notVisibleObjects: MutableList<GameObject> = ArrayList()
) : GameLevel {

    override var guiLayer: GuiLayer
        get() = TODO("Not yet implemented")
        set(value) {}
    override var listGameLayers: MutableList<GameLevel>
        get() = TODO("Not yet implemented")
        set(value) {}

    private val player: Player

    init {
        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var downIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_4.png")
            .addFrame("sprites/characters/soldier/sprite_5.png")
            .addFrame("sprites/characters/soldier/sprite_6.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.DOWN)

        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var rightIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_1.png")
            .addFrame("sprites/characters/soldier/sprite_2.png")
            .addFrame("sprites/characters/soldier/sprite_3.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.RIGHT)

        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var upIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_7.png")
            .addFrame("sprites/characters/soldier/sprite_8.png")
            .addFrame("sprites/characters/soldier/sprite_9.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.UP)

        SpriteFactory.height = 30.0
        SpriteFactory.width = 30.0
        SpriteFactory.scale = 4.0
        SpriteFactory.animationSpeed = 1
        var leftIdleAnimation = SpriteFactory.addFrame("sprites/characters/soldier/sprite_10.png")
            .addFrame("sprites/characters/soldier/sprite_11.png")
            .addFrame("sprites/characters/soldier/sprite_12.png")
            .getAnimation(AnimationStance.IDLE, AnimationDirection.LEFT)

        player = Player(Position(70.0, 200.0), speed = 300.0)
        player.objectSprites?.addAnimation(downIdleAnimation)
        player.objectSprites?.addAnimation(rightIdleAnimation)
        player.objectSprites?.addAnimation(upIdleAnimation)
        player.objectSprites?.addAnimation(leftIdleAnimation)

    }
}