package com.kroman.presentation.ui.components

import com.kroman.domain.model.Source

data class ArticleItem(
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    val publishedAt: String,
    val source: Source,
    val isBookmarked: Boolean
)
