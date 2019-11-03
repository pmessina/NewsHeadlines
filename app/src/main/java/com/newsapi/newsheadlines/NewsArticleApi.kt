package com.newsapi.newsheadlines

import retrofit2.Call
import retrofit2.http.GET

interface NewsArticleApi {
    @GET("v2/top-headlines?country=us&category=entertainment&apiKey=f6aa3bfb89aa4d3eb96dddf97e11aa70")
    fun listArticles(): Call<NewsArticles>
}