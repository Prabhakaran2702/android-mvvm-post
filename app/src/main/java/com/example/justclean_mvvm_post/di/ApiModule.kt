package com.example.justclean_mvvm_post.di

import com.example.justclean_mvvm_post.data.remote.PostApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    single { providePostApi(get()) }

}