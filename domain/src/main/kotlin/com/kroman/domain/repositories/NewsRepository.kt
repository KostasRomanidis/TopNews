package com.kroman.domain.repositories

import com.kroman.domain.model.Article
import com.kroman.domain.model.Result

interface NewsRepository : BaseRepository {
    suspend fun getTopHeadlines(
        lang: String,
        token: String
    ): Result<List<Article>>
}