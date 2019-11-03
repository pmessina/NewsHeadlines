package com.newsapi.newsheadlines

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(context: Context, val view: View) : RecyclerView.ViewHolder(view) {
    var title: TextView = view.findViewById(R.id.tvTitle)
    var author: TextView = view.findViewById(R.id.tvAuthor)
    var description: TextView = view.findViewById(R.id.tvDescription)
    var image: ImageView = view.findViewById(R.id.imgArticleURL)
    var url: String = ""

    init {
        view.setOnClickListener {

            val url = it.tag.toString()
            val intent = Intent(
                context,
                NewsUrlActivity::class.java
            )
            intent.putExtra("Url", url)
            context.startActivity(intent)
        }
    }
}