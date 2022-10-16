package com.kroman.data.datasource

import com.kroman.data.datasource.dao.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun providesArticleDao(
        database: TopNewsDatabase
    ): ArticleDao = database.articleDao()
}