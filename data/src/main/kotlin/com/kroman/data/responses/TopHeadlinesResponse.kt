package com.kroman.data.responses

import com.kroman.data.model.ArticleEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopHeadlinesResponse(
    @Json(name = "totalArticles") val totalArticles: Int,
    @Json(name = "articles") val articles: List<ArticleEntity>
)
