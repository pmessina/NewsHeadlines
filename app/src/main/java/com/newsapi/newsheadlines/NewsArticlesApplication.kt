package com.newsapi.newsheadlines

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class NewsArticlesApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsArticlesApplication)
            modules(myModule)
        }
    }

}

val myModule : Module = module {
    viewModel { NewsArticleViewModel(get())  }
    single{NewsRepository()}
}