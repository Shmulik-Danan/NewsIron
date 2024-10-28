package com.shmulik.data.util

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.shmulik.data.entities.NewsData

object JsonLoader {
    private val gson = GsonBuilder().create()

    fun loadNews(): List<NewsData> = fromJsonList("articles.json")

    private inline fun <reified T> fromJsonList(fileName: String): List<T> =
        javaClass.classLoader!!.getResource(fileName)!!.readText().let {
            gson.fromJson(it, object : TypeToken<List<T>>() {}.type)
        }
}