package com.example.justclean_mvvm_post.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post

@Database(entities = [Post::class,Favourite::class,Comment::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val postDao:PostDao
    abstract val favDao:FavDao
    abstract val comDao:CommentDao
}