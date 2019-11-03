package com.newsapi.newsheadlines

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsArticleApi {
    @GET("v2/top-headlines?country=us&category=entertainment&apiKey=f6aa3bfb89aa4d3eb96dddf97e11aa70")
    fun listArticles(): Call<NewsArticles>
}

class NewsArticleViewModel : ViewModel() {
    fun getRepository(): LiveData<NewsArticles> {
        return NewsRepository().getNews()
    }
}

class NewsRepository() {

    var newsApi: NewsArticleApi
    lateinit var liveData: MutableLiveData<NewsArticles>

    var retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://newsapi.org/").build()

    init {
        newsApi = retrofit.create(NewsArticleApi::class.java)
    }

    fun getNews(): MutableLiveData<NewsArticles> {
        val newsData = MutableLiveData<NewsArticles>()

        newsApi.listArticles().enqueue(object : Callback<NewsArticles> {
            override fun onResponse(call: Call<NewsArticles>, response: Response<NewsArticles>) {
                newsData.value = response.body()
                Log.i("NewsApi", response.body().toString())
            }

            override fun onFailure(call: Call<NewsArticles>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return newsData
    }
}