package com.example.justclean_mvvm_post.data.repository

import android.app.Application
import com.example.justclean_mvvm_post.data.local.CommentDao
import com.example.justclean_mvvm_post.data.local.FavDao
import com.example.justclean_mvvm_post.data.local.PostDao
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.remote.PostApi
import com.example.justclean_mvvm_post.utils.Util

class DetailRepository(private val application: Application, private val postApi: PostApi, private val favDao: FavDao,
                       private val postDao: PostDao,private val commentDao: CommentDao) {


    suspend fun getPost(id:Int): Post {

        return if( Util.isNetworkConnected(application.applicationContext)){
            postApi.getPost(id).await()
        } else{
            postDao.getPost(id)
        }

    }


    suspend fun getComments(id:Int): List<Comment> {

        return if(Util.isNetworkConnected(application.applicationContext)){
            val res= postApi.getComments(id).await()
            commentDao.insertComments(*res.toTypedArray())
            res
        } else{
            commentDao.getComments(id)
        }

    }

    suspend fun addFavourite(fav:Favourite) {
        favDao.insertFav(fav)
    }

    suspend fun deleteFavourite(id:Int) {
        favDao.deleteFav(id)
    }


}