package com.loc.newsapp.data.remote

import com.loc.newsapp.BuildConfig
import com.loc.newsapp.data.remote.dto.NewsResponse
import com.loc.newsapp.data.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")//https://newsapi.org/v2/everything?q=bitcoin&apiKey=5ab700bc5b9d4313933b841e2b3219c1
    suspend fun getNews(
        @Query("page")  page :Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey:String = BuildConfig.API_KEY
    ) : NewsResponse


    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page")  page :Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey:String = BuildConfig.API_KEY
    ): NewsResponse
}