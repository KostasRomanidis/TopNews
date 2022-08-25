package com.kroman.presentation.models

import com.kroman.domain.model.Article
import com.kroman.presentation.utils.DateUtils

data class ArticleItem(
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    val publishedAt: String,
    val source: SourceItem,
    val isBookmarked: Boolean
)

fun Article.mapToPresentation(): ArticleItem =
    ArticleItem(
        title = this.title,
        description = this.description,
        content = this.content,
        url = this.url,
        image = this.image,
        publishedAt = DateUtils.formatDate(this.publishedAt),
        source = this.source.mapToPresentation(),
        isBookmarked = false
    )

fun List<Article>.mapToPresention(): List<ArticleItem> = map { it.mapToPresentation() }