package com.shmulik.data.di.repo

import com.shmulik.data.repository.news.NewsRepositoryImpl
import com.shmulik.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsPhotoRepository(impl: NewsRepositoryImpl): NewsRepository
}