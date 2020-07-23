package com.kroman.domain.repositories

import com.kroman.domain.model.Article
import com.kroman.domain.model.Result

interface NewsRepository : BaseRepository {
    suspend fun getLatestArticles(
        q: String, from: String,
        to: String,
        sortBy: String,
        apiKey: String
    ): Result<List<Article>>
}