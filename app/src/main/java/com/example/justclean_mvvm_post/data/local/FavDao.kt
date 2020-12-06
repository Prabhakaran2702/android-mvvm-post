package com.example.justclean_mvvm_post.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post


@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(fav: Favourite)

    @Query("SELECT * FROM favourite")
    suspend fun getAllFavs(): List<Favourite>

    @Query("SELECT * FROM favourite WHERE id = :postId")
    suspend fun getFav(postId: Int): Favourite

    @Query("DELETE FROM favourite WHERE id = :postId")
    suspend fun deleteFav(postId: Int)

}