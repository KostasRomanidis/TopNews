package com.kroman.data.model

import com.kroman.domain.model.Source
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SourceEntity(
    val name: String,
    val url: String
)

fun SourceEntity.mapToDomain(): Source = Source(
    name = name,
    url = url
)
