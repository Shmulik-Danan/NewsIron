package com.shmulik.data.repository.news

import com.shmulik.data.entities.NewsData
import com.shmulik.domain.util.DataResult

interface NewsDataSource {
    interface Remote {
         suspend fun getNews(): DataResult<List<NewsData>>
    }
    interface Local {
        suspend fun getNews(): DataResult<List<NewsData>>
    }
}