package com.kroman.data.api

import com.kroman.data.responses.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun topHeadelines(
        @Query("lang") lang: String
    ): TopHeadlinesResponse
}
