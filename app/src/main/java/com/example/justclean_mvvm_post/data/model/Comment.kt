package com.example.justclean_mvvm_post.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Comment(

    @ColumnInfo(name = "comment_id")
    val id: Int,
    @ColumnInfo(name = "post_id")
    val postId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "body")
    val body: String
)