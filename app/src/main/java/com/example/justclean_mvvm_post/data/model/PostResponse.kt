package com.example.justclean_mvvm_post.data.model


    data class PostResponse(
        var isError: Boolean,
        val posts: ArrayList<Post>? = null,
        )

