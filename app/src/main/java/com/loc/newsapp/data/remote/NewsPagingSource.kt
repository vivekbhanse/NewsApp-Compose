package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.models.Article

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val source: String,
): PagingSource<Int,Article>() {
    private var totalNewsCount=0


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page=params.key ?: 1
        return try {

            val newsResponse = newsApi.getNews(page = page, string = source)
                totalNewsCount += newsResponse.articles.size

                val article = newsResponse.articles.distinctBy { it.title }
                LoadResult.Page(
                    data = article,
//                    if (totalNewsCount == newsResponse.totalResults) null else page + 1, // Need Premium Account to get all news
                    if (totalNewsCount > 200) null else page + 1,
                    null
                )
        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
      return state.anchorPosition?.let { anchorPosition ->
        val anchorPage=state.closestPageToPosition(anchorPosition)
          anchorPage?.prevKey?.plus(1) ?: anchorPage ?.nextKey?.minus(1)
      }
    }
}