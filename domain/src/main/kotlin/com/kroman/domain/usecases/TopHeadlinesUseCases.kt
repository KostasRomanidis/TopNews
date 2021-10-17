package com.kroman.domain.usecases

import com.kroman.domain.model.Article
import com.kroman.domain.model.Result
import com.kroman.domain.repositories.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopHeadlinesUseCases @Inject constructor(private val articleRepository: NewsRepository) {

    suspend fun loadLatestArticles(
        lang: String
    ): Result<List<Article>> =
        coroutineScope {
            withContext(Dispatchers.IO) {
                articleRepository.getTopHeadlines(lang = lang)
            }
        }
}