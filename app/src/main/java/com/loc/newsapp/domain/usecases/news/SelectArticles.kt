package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.domain.models.Article
import kotlinx.coroutines.flow.Flow


class SelectArticles(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}