package com.loc.newsapp.presentation.details

import com.loc.newsapp.domain.models.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()
}