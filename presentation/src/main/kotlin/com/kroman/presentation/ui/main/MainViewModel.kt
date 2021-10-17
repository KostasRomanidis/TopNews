package com.kroman.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroman.domain.usecases.TopHeadlinesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.kroman.domain.model.Result
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val topHeadlinesUseCases: TopHeadlinesUseCases) : ViewModel() {

    fun getTopHeadlines() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                when (val result = topHeadlinesUseCases.loadLatestArticles(
                    "en"
                )) {
                    is Result.Success -> {
                        Timber.d(result.data.toString())
                    }
                    is Result.Error -> {
                        Timber.e(result.exception)
                    }
                }
            }
        }
    }
}