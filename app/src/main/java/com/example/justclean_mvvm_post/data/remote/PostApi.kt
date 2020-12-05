package com.example.justclean_mvvm_post.data.remote

import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Post
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("posts")
     fun getPosts(): Deferred<List<Post>>

    @GET("posts/{id}/comments")
     fun getComments(@Path("id") id: Int): Single<List<Comment>>

}