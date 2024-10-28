package com.shmulik.newsiron.ui.page.feed

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shmulik.domain.entities.NewsEntity
import com.shmulik.domain.repository.NewsRepository
import com.shmulik.domain.util.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedPageViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel(), FeedContract.ViewModel {

    override val news = MutableStateFlow<List<NewsEntity>>(emptyList())

    private val originalNews = mutableListOf<NewsEntity>()

    init {
        viewModelScope.launch {
            getNews()
        }
    }

    private suspend fun getNews() {
        when (val result = repository.getNews()) {
            is DataResult.Success -> {
                originalNews.addAll(result.data)
                news.value = result.data
            }

            is DataResult.Error -> TODO()
        }

    }

    override fun onFilterClick(filterData: List<Filter>) {
        viewModelScope.launch {
            val newNews = mutableListOf<NewsEntity>()

            news.value.forEach { news ->
                val isAllPasse = filterData.map { it.doFilter(news) }
                if (isAllPasse.contains(false).not()) {
                    newNews.add(news)
                }
            }
            news.emit(newNews)

        }

    }
}
