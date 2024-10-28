package com.shmulik.data.repository.news

import com.shmulik.data.entities.NewsData
import com.shmulik.domain.util.DataResult
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(
//   val newsApi: NewsApi
) : NewsDataSource.Remote {

    override suspend fun getNews(): DataResult<List<NewsData>> {
        return DataResult.Success(listOf(NewsData()))
    }
}