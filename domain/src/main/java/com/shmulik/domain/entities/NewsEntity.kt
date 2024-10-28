package com.shmulik.domain.entities

import androidx.compose.ui.graphics.Color


data class NewsEntity(
    val title: String,
    val description: String,
    val imageUrl: String,
    val rating: Int,
    val placeholderColor: PlaceHolderColor
)

data class PlaceHolderColor(
    val red: Int,
    val green: Int,
    val blue: Int
)
fun PlaceHolderColor.toColor(): Color {
    return Color(red, green, blue)
}