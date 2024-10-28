package com.shmulik.domain.repository

import com.shmulik.domain.entities.NewsEntity
import com.shmulik.domain.util.DataResult


interface NewsRepository {
    suspend fun getNews(): DataResult<List<NewsEntity>>
}