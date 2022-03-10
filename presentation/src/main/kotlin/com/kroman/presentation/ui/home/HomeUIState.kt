package com.kroman.presentation.ui.home

import com.kroman.presentation.models.ArticleItem

sealed interface HomeUIState {
    val isLoading: Boolean
    val errorMessage: String?

    data class NoArticles(
        override val isLoading: Boolean,
        override val errorMessage: String?
    ) : HomeUIState

    data class HasArticles(
        override val isLoading: Boolean,
        override val errorMessage: String?,
        val articles: List<ArticleItem>?
    ) : HomeUIState
}