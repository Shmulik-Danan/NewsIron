package com.shmulik.data.repository.news


import com.shmulik.data.entities.toDomain
import com.shmulik.domain.entities.NewsEntity
import com.shmulik.domain.repository.NewsRepository
import com.shmulik.domain.util.DataResult
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val dataSource: NewsDataSource.Remote,
    private val localDataSource: NewsDataSource.Local

) : NewsRepository {

    override suspend fun getNews(): DataResult<List<NewsEntity>> {
        return when (val result = localDataSource.getNews()) {
            is DataResult.Success -> {
                DataResult.Success(result.data.map { it.toDomain() })
            }

            is DataResult.Error -> {
                DataResult.Error(result.error)
            }
        }
    }


}