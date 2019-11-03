package com.newsapi.newsheadlines

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NewsArticleViewModel(val newsRepository: NewsRepository) : ViewModel() {
    fun getRepository(): LiveData<NewsArticles> {
        return newsRepository.getNews()
    }
}