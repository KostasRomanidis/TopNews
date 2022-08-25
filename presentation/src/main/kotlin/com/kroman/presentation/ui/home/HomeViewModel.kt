package com.kroman.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroman.domain.model.Result
import com.kroman.domain.usecases.TopHeadlinesUseCases
import com.kroman.presentation.models.ArticleItem
import com.kroman.presentation.models.mapToPresention
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val topHeadlinesUseCases: TopHeadlinesUseCases) :
    ViewModel() {
    private val _viewState: MutableStateFlow<HomeViewModelState> =
        MutableStateFlow(HomeViewModelState(isLoading = true))

    val uiState = _viewState
        .map { it.mapToUIState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            _viewState.value.mapToUIState()
        )

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                when (val result = topHeadlinesUseCases.loadLatestArticles(
                    "en"
                )) {
                    is Result.Success -> {
                        Timber.d(result.data.toString())
                        _viewState.update {
                            it.copy(
                                isLoading = false,
                                feed = result.data.mapToPresention()
                            )
                        }
                    }
                    is Result.Error -> {
                        Timber.e(result.exception)
                        _viewState.update {
                            it.copy(
                                isLoading = false,
                                feed = null,
                                errorMessage = result.exception.message
                            )
                        }
                    }
                }
            }
        }
    }

    fun clickItem() {
        Timber.d("Item clicked")
    }
}

data class HomeViewModelState(
    val isLoading: Boolean,
    val feed: List<ArticleItem>? = null,
    var errorMessage: String? = null
) {
    fun mapToUIState(): HomeUIState =
        if (feed == null) {
            HomeUIState.NoArticles(
                isLoading = isLoading,
                errorMessage = errorMessage
            )
        } else {
            HomeUIState.HasArticles(
                isLoading = isLoading,
                articles = feed,
                errorMessage = errorMessage
            )
        }
}