package com.kroman.domain.repositories

import com.kroman.domain.model.Result
import kotlinx.coroutines.Deferred

interface BaseRepository {
    suspend fun <T> requestAwait(
        call: () -> Deferred<T>
    ): Result<T> {
        return try {
            val result = call().await()
            Result.success(result)
        } catch (exception: Exception) {
            Result.error(exception)
        }
    }

    suspend fun <T> request(call: suspend () -> T): Result<T> {
        return try {
            Result.success(call())
        } catch (exception: Exception) {
            Result.error(exception)
        }
    }
}