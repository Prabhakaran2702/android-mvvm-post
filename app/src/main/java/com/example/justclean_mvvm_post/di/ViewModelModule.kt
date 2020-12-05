package com.example.justclean_mvvm_post.di

import com.example.justclean_mvvm_post.ui.post.PostViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { PostViewModel(get()) }
}