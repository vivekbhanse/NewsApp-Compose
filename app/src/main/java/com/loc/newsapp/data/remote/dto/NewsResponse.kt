package com.loc.newsapp.data.remote.dto

import com.loc.newsapp.domain.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)