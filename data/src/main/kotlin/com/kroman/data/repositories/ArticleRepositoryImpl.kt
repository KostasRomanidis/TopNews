package com.kroman.data.repositories

import com.kroman.data.api.NewsApi
import com.kroman.data.model.mapToDomain
import com.kroman.domain.model.Article
import com.kroman.domain.model.Result
import com.kroman.domain.repositories.NewsRepository
import timber.log.Timber

class ArticleRepositoryImpl(val newsApi: NewsApi) : NewsRepository {
    override suspend fun getTopHeadlines(
        lang: String,
        token: String
    ): Result<List<Article>> {
        Timber.d("loading latest articles from news api, for the last 24hours")
        return when (val response =
            request { newsApi.topHeadelines(lang, token) }) {
            is Result.Success -> Result.success(response.data.articles.mapToDomain())
            is Result.Error -> Result.error(response.exception)
        }
    }
}