package com.kroman.data.datasource.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ArticleSource(
    @Embedded val article: Article,
    @Relation(
        parentColumn = "articleId",
        entityColumn = "articleSourceId"
    )
    val source: Source
)
