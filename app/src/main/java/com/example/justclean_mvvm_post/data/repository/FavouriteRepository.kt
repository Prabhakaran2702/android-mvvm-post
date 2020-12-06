package com.example.justclean_mvvm_post.data.repository

import com.example.justclean_mvvm_post.data.local.FavDao
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post

class FavouriteRepository(private val favDao: FavDao) {


    suspend fun getFavourites(): List<Favourite> {
      return favDao.getAllFavs()
    }

    suspend fun addFavourite(fav:Favourite) {
       favDao.insertFav(fav)
    }

    suspend fun getFavourite(id:Int): Favourite {
        return favDao.getFav(id)
    }

    suspend fun deleteFavourite(id:Int) {
        return favDao.deleteFav(id)
    }

}