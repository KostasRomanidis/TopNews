package com.kroman.presentation.di

import com.kroman.data.repositories.ArticleRepositoryImpl
import com.kroman.domain.repositories.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindArticlesRepository(articleRepositoryImpl: ArticleRepositoryImpl): NewsRepository
}