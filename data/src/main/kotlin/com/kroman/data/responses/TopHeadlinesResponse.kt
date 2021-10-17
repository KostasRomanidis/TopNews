package com.kroman.data.responses

import com.kroman.data.model.ArticleEntity

data class TopHeadlinesResponse(
    val totalArticles: Int,
    val articles: List<ArticleEntity>
)
