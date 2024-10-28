package com.shmulik.newsiron.navigaion

import kotlinx.serialization.Serializable

object Route {


    @Serializable
    object MainNewsRoute

    @Serializable
    object FeedRoute


}

sealed class Graph {
    @Serializable
    data object Main : Graph()
}