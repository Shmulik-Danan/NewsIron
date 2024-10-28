package com.shmulik.newsiron.ui.page.feed

import com.shmulik.domain.entities.NewsEntity
import kotlinx.coroutines.flow.StateFlow

interface FeedContract {

    interface ViewModel {
        val news: StateFlow<List<NewsEntity>>

        fun onFilterClick(list: List<Filter>)
    }
}