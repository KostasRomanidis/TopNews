package com.kroman.data.model

import com.kroman.domain.model.Article
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleEntity(
    val title: String,
    val description: String,
    val content: String,
    val url: String,
    val image: String,
    val publishedAt: String,
    val source: SourceEntity,
)

fun ArticleEntity.mapToDomain(): Article = Article(
    title = title,
    description = description,
    content = content,
    url = url,
    image = image,
    publishedAt = publishedAt,
    source = source.mapToDomain()
)

fun List<ArticleEntity>.mapToDomain(): List<Article> = map { it.mapToDomain() }