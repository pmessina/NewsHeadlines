package com.newsapi.newsheadlines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_activity.*


class NewsHeadlinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }

        val viewModel = ViewModelProviders.of(this).get(NewsArticleViewModel::class.java)
        viewModel.getRepository().observe(this, Observer { t ->
            rvNewsHeadlines.adapter = NewsHeadlinesAdapter(this, t.articles)
            rvNewsHeadlines.layoutManager = LinearLayoutManager(this)
        })
    }

}


