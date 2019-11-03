package com.newsapi.newsheadlines

import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName(value = "source")
    val source: Source?,
    @SerializedName(value = "author")
    val author: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "description")
    val description:String,
    @SerializedName(value = "url")
    val url:String,
    @SerializedName(value = "urlToImage")
    val urlToImage: String,
    @SerializedName(value = "publishedAt")
    val publishedAt: String,
    @SerializedName(value = "content")
    val content: String
    )


data class NewsArticles (@SerializedName(value = "status") val status: String,
    @SerializedName(value = "totalResults") val totalResults: Int,
    @SerializedName(value = "articles") val articles: ArrayList<Article>
    )

data class Source (
    @SerializedName(value = "id") val id: String? = null,
    @SerializedName(value = "name") val name: String
)