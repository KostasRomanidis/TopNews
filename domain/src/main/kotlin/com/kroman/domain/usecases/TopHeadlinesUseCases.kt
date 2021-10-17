package com.kroman.domain.usecases

import com.kroman.domain.model.Article
import com.kroman.domain.model.Result
import com.kroman.domain.repositories.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class TopHeadlinesUseCases(private val articleRepository: NewsRepository) {

    suspend fun loadLatestArticles(
        lang: String,
        token: String
    ): Result<List<Article>> =
        coroutineScope {
            withContext(Dispatchers.IO) {
                articleRepository.getTopHeadlines(lang = lang, token = token)
            }
        }
}