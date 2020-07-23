package com.kroman.data.api

import com.kroman.data.model.ArticleEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/everything")
    suspend fun latestArticles(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): List<ArticleEntity>
}
