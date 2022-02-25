package com.kroman.presentation.models

import com.kroman.domain.model.Source

data class SourceItem(
    val name: String,
    val url: String
)

fun Source.MapToPresentation() : SourceItem {
    return SourceItem(
        this.name,
        this.url
    )
}