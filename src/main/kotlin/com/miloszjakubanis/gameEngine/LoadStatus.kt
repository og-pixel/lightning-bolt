package com.miloszjakubanis

/**
 * Implementing this interface gives access to extract information
 * about state that the object is loaded
 */
//TODO add time keeping capability
//TODO add event handling that will notify user if object is loading for a long time
interface LoadStatus {

    var currentIteration: Int

    val noOfIterations: Int

    val progress: Int
        get() = (currentIteration / noOfIterations) * 100


    fun clearLoading() {
        currentIteration = 0
    }
}

