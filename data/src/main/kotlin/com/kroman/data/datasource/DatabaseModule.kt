package com.kroman.data.datasource

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesTopNewsDatabase(
        @ApplicationContext context: Context
    ): TopNewsDatabase = Room.databaseBuilder(
        context,
        TopNewsDatabase::class.java,
        "topnews-database"
    ).build()
}