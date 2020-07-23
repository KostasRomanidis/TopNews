package com.kroman.data.model

import com.kroman.domain.model.Source

data class SourceEntity(val id: String, val name: String)

fun SourceEntity.mapToDomain(): Source = Source(
    id = id,
    name = name
)