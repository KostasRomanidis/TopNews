package com.kroman.presentation.models

import com.kroman.domain.model.Article
import com.kroman.domain.model.Source

data class ArticleItem(
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    val publishedAt: String,
    val source: SourceItem,
)

fun Article.MapToPresentation() : ArticleItem =
    ArticleItem(
        this.title,
        this.description,
        this.content,
        this.url,
        this.image,
        this.publishedAt,
        this.source.MapToPresentation()
    )

fun List<Article>.MapToPresention() : List<ArticleItem> = map { it.MapToPresentation() }