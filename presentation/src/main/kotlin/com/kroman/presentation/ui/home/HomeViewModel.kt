package com.kroman.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroman.domain.model.Result
import com.kroman.domain.usecases.TopHeadlinesUseCases
import com.kroman.presentation.models.ArticleItem
import com.kroman.presentation.models.MapToPresention
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val topHeadlinesUseCases: TopHeadlinesUseCases) : ViewModel() {
    private val _newsFeed: MutableLiveData<List<ArticleItem>> = MutableLiveData()
    val newsFeed: LiveData<List<ArticleItem>> = _newsFeed

    fun getTopHeadlines() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                when (val result = topHeadlinesUseCases.loadLatestArticles(
                    "en"
                )) {
                    is Result.Success -> {
                        Timber.d(result.data.toString())
                        _newsFeed.value = result.data.MapToPresention()
                    }
                    is Result.Error -> {
                        Timber.e(result.exception)
                    }
                }
            }
        }
    }
}