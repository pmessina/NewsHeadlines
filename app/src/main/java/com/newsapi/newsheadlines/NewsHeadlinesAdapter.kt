package com.newsapi.newsheadlines

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsHeadlinesAdapter(
    private val context: Context,
    private val newsArticles: ArrayList<Article>
) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(context)
                .inflate(R.layout.main_fragment_article, parent, false)
        return NewsViewHolder(context, view)
    }

    override fun getItemCount(): Int {
        return newsArticles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.author.text = newsArticles[position].author
        holder.title.text = newsArticles[position].title
        holder.description.text = newsArticles[position].description
        Glide.with(context).load(newsArticles[position].urlToImage).into(holder.image)
        holder.url = newsArticles[position].url
        holder.view.tag = holder.url
    }

}