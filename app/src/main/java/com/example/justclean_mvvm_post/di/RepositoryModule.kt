package com.example.justclean_mvvm_post.di

import android.app.Application
import com.example.justclean_mvvm_post.data.local.CommentDao
import com.example.justclean_mvvm_post.data.local.FavDao
import com.example.justclean_mvvm_post.data.local.PostDao
import com.example.justclean_mvvm_post.data.remote.PostApi
import com.example.justclean_mvvm_post.data.repository.DetailRepository
import com.example.justclean_mvvm_post.data.repository.FavouriteRepository
import com.example.justclean_mvvm_post.data.repository.PostRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun providePostRepository(application: Application,api: PostApi, dao: PostDao): PostRepository {
        return PostRepository(application,api, dao)
    }

    fun provideFavouriteRepository(dao: FavDao): FavouriteRepository {
        return FavouriteRepository(dao)
    }

    fun provideDetailRepository(application: Application,api: PostApi,favDao: FavDao,postDao: PostDao,commentDao: CommentDao): DetailRepository {
        return DetailRepository(application,api,favDao,postDao,commentDao)
    }

    single { providePostRepository(get(),get(),get()) }
    single { provideFavouriteRepository(get()) }
    single { provideDetailRepository(get(),get(),get(),get(),get()) }

}