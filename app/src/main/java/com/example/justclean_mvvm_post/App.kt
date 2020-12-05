package com.example.justclean_mvvm_post

import android.app.Application
import com.example.justclean_mvvm_post.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(networkModule)
            modules(apiModule)
        }
    }

}
