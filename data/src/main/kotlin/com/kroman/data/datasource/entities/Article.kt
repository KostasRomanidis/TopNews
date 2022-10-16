package com.kroman.data.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kroman.data.model.SourceEntity

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true) val articleId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "published_at") val publishedAt: String,
)
