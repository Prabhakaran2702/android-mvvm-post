package com.example.justclean_mvvm_post.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.justclean_mvvm_post.data.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val postDao:PostDao
}