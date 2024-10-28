package com.shmulik.data.repository.news

import com.shmulik.data.entities.NewsData
import com.shmulik.data.util.JsonLoader
import com.shmulik.domain.util.DataResult
import javax.inject.Inject

class NewsLocalDataSource @Inject constructor(
//   val newsApi: NewsApi
) : NewsDataSource.Local {

    override suspend fun getNews(): DataResult<List<NewsData>> {
        val l = JsonLoader.loadNews()
        return DataResult.Success(l)
    }
}