package com.shmulik.data.di.datasource


import com.shmulik.data.repository.news.NewsDataSource
import com.shmulik.data.repository.news.NewsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {

    @Binds
    @Singleton
    fun bindsRemotePhotoDataSource(impl: NewsRemoteDataSource): NewsDataSource.Remote
}