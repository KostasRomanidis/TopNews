package com.kroman.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kroman.data.datasource.dao.ArticleDao
import com.kroman.data.datasource.entities.Article
import com.kroman.data.datasource.entities.Source

@Database(entities = [Article::class, Source::class], version = 1, exportSchema = true)
abstract class TopNewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}