package com.shmulik.data.di.datasource


import com.shmulik.data.repository.news.NewsDataSource
import com.shmulik.data.repository.news.NewsLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    @Singleton
    fun bindsRemotePhotoDataSource(impl: NewsLocalDataSource): NewsDataSource.Local
}