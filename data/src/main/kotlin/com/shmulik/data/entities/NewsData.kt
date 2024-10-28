package com.shmulik.data.entities

import com.shmulik.domain.entities.NewsEntity
import com.shmulik.domain.entities.PlaceHolderColor


data class NewsData(
    val title: String = "",
    val description: String = "",
    val image_url: String = "",
    val rating: Int= 1,
    val placeholderColor: PlaceholderColor = PlaceholderColor()
)

data class PlaceholderColor(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0

)

fun NewsData.toDomain() = NewsEntity(
    title = title,
    description = description,
    imageUrl = image_url,
    rating = rating,
    placeholderColor =placeholderColor.toDomain()
)

fun PlaceholderColor.toDomain() = PlaceHolderColor(
    red = red,
    green = green,
    blue = blue
)