package com.example.justclean_mvvm_post.di

import com.example.justclean_mvvm_post.data.local.PostDao
import com.example.justclean_mvvm_post.data.remote.PostApi
import com.example.justclean_mvvm_post.data.repository.PostRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun providePostRepository(api: PostApi, dao: PostDao): PostRepository {
        return PostRepository(api, dao)
    }

    single { providePostRepository(get(),get()) }

}