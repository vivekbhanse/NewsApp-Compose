package com.loc.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.domain.usecases.news.GetNews
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {
    private val _news = MutableStateFlow<PagingData<Article>>(PagingData.empty())
    val news: StateFlow<PagingData<Article>> = _news

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // Collect the Flow<PagingData<Article>> from getNews and update the _news StateFlow
            newsUseCases.getNews(listOf("bbc_news", "abc-news"))
                .cachedIn(viewModelScope) // Ensure the paging data is cached in the viewModelScope
                .collect { pagingData ->
                    _news.value = pagingData // Update the StateFlow with new PagingData
                }
        }
    }

   }