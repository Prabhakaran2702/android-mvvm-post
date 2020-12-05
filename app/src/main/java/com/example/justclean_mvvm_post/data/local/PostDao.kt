package com.example.justclean_mvvm_post.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.justclean_mvvm_post.data.model.Post

@Dao
interface PostDao {

    @Insert
    suspend fun insertAll(vararg posts: Post): List<Long>

    @Query("SELECT * FROM post")
    suspend fun getAllPosts(): List<Post>

    @Query("SELECT * FROM post WHERE id = :postId")
    suspend fun getPost(postId: Int): Post

    @Query("DELETE FROM post")
    suspend fun deleteAllPost()


}