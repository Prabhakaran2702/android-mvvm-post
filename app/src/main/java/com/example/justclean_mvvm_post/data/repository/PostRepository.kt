package com.example.justclean_mvvm_post.data.repository

import android.app.Application
import android.widget.Toast
import com.example.justclean_mvvm_post.data.local.PostDao
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.model.PostResponse
import com.example.justclean_mvvm_post.data.remote.PostApi
import com.example.justclean_mvvm_post.utils.Util
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class PostRepository(private val application: Application,private val postApi: PostApi, private val postDao: PostDao) {


    suspend fun getPosts(): List<Post> {

        return if( Util.isNetworkConnected(application.applicationContext)){
            val res= postApi.getPosts().await()
            postDao.insertAll(*res.toTypedArray())
            res
        } else{
            postDao.getAllPosts()
        }
    }


}
