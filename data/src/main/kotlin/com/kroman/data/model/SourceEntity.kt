package com.kroman.data.model

import com.kroman.domain.model.Source

data class SourceEntity(
    val name: String,
    val url: String
)

fun SourceEntity.mapToDomain(): Source = Source(
    name = name,
    url = url
)
