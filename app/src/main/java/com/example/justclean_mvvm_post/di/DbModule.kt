package com.example.justclean_mvvm_post.di

import android.app.Application
import androidx.room.Room
import com.example.justclean_mvvm_post.data.local.AppDatabase
import com.example.justclean_mvvm_post.data.local.PostDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "eds.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun providePostDao(database: AppDatabase): PostDao {
        return database.postDao
    }

    single { provideAppDatabase(androidApplication()) }
    single { providePostDao(get()) }
}