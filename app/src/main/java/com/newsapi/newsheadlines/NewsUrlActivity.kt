package com.newsapi.newsheadlines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news_url.*
import kotlinx.android.synthetic.main.fragment_news_url.*

class NewsUrlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_url)
        setSupportActionBar(toolbar)

        val url = intent.extras!!["Url"].toString()
        wvArticleURL.loadUrl(url)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
