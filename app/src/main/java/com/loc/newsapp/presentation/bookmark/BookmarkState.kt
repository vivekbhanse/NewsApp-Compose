package com.loc.newsapp.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.loc.newsapp.domain.models.Article
import com.loc.newsapp.domain.usecases.news.DeleteArticle

data class BookmarkState(
    val article: List<Article> = emptyList()
) {

}