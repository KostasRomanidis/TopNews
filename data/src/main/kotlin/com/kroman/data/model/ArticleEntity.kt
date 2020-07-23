package com.kroman.data.model

import com.kroman.domain.model.Article

data class ArticleEntity(
    val source: SourceEntity,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

fun ArticleEntity.mapToDomain(): Article = Article(
    source = source.mapToDomain(),
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)

fun List<ArticleEntity>.mapToDomain(): List<Article> = map { it.mapToDomain() }