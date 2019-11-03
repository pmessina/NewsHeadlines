package com.newsapi.newsheadlines

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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