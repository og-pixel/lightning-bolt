package com.miloszjakubanis.gameObject.orders

import com.miloszjakubanis.gameObject.GameObject

interface Command {

    val gameObject:GameObject

    fun executeCommand()

    fun removeCommand()
}