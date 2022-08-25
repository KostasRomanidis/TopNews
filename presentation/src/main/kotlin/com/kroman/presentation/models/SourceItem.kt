package com.kroman.presentation.models

import com.kroman.domain.model.Source

data class SourceItem(
    val name: String,
    val url: String
)

fun Source.mapToPresentation() : SourceItem {
    return SourceItem(
        this.name,
        this.url
    )
}