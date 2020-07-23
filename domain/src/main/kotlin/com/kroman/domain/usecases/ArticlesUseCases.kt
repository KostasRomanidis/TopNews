package com.kroman.domain.usecases

import com.kroman.domain.model.Article
import com.kroman.domain.model.Result
import com.kroman.domain.repositories.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class ArticlesUseCases(private val articleRepository: NewsRepository) {

    suspend fun loadLatestArticles(
        q: String,
        from: String,
        to: String,
        sortBy: String,
        apiKey: String
    ): Result<List<Article>> =
        coroutineScope {
            withContext(Dispatchers.IO) {
                articleRepository.getLatestArticles(q, from, to, sortBy, apiKey)
            }
        }
}