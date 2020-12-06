package com.example.justclean_mvvm_post.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Post

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(vararg posts: Comment): List<Long>

    @Query("SELECT * FROM comment WHERE post_id=:postId")
    suspend fun getComments(postId: Int): List<Comment>

}