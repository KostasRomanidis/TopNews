package com.kroman.presentation.di

import com.kroman.data.repositories.ArticleRepositoryImpl
import com.kroman.domain.repositories.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ArticleRepositoryImpl(newsApi = get()) as NewsRepository }
}