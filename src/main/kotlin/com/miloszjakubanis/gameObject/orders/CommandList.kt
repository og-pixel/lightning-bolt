package com.miloszjakubanis.gameObject.orders

class CommandList {

    private val commandList: MutableList<Command> = ArrayList()


    //TODO remove a command once it is finished
    fun removeCommand() {
        commandList.removeAt(0)
    }

    fun getNextCommand(): Command? {
        if (commandList.isEmpty()) return null
        return commandList[0]
    }

    fun addCommand(command: Command) {
        commandList.add(command)
    }
}