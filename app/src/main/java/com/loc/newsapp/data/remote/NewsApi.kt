package com.loc.newsapp.data.remote

import com.loc.newsapp.data.remote.dto.NewsResponse
import com.loc.newsapp.data.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page")  page :Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey:String = Constants.API_KEY
    ) : NewsResponse
}