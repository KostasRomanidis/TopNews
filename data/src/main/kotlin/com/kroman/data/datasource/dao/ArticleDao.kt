package com.kroman.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.kroman.data.datasource.entities.Article
import com.kroman.data.datasource.entities.ArticleSource

/**
 * DAO for [Article] access
 */
@Dao
interface ArticleDao {
    @Query("SELECT * FROM article ORDER BY published_at ASC")
    fun getAll(): List<Article>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnoreArticle(article: Article)

    @Transaction
    @Query("SELECT * FROM article")
    fun getArticlesWithSources(): List<ArticleSource>
}