package com.shmulik.newsiron.ui.page.feed

import com.shmulik.domain.entities.NewsEntity


data class FeedUiState(
    val isLoading: Boolean = false,
    val error: Throwable? = null
)

data class FilterText(val text: String = "")

val listOfFilters = mutableListOf<Filter>()

sealed class Filter {
    open fun doFilter(newsEntity: NewsEntity): Boolean {
        return false
    }

    data class Title(val text: String? = null) : Filter() {
        override fun doFilter(newsEntity: NewsEntity): Boolean {
            text?:return true
            return newsEntity.title.contains(text)
        }
    }

    data class Rating(val rating: Int? = null) : Filter() {
        override fun doFilter(newsEntity: NewsEntity): Boolean {
            rating?:return true
            return newsEntity.rating == rating
        }
    }
}



