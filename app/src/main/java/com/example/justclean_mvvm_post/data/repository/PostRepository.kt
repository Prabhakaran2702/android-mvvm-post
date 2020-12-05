package com.example.justclean_mvvm_post.data.repository

import android.widget.Toast
import com.example.justclean_mvvm_post.data.local.PostDao
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.model.PostResponse
import com.example.justclean_mvvm_post.data.remote.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class PostRepository(private val postApi: PostApi, private val postDao: PostDao) {


    suspend fun getPosts(): List<Post> {

        val res= postApi.getPosts().await()

//       res?.let {
//          postDao.deleteAllPost()
//          postDao.insertAll(*res.toTypedArray())
//       }
//       return postDao.getAllPosts()

       return res

    }

    suspend fun getPost(id:Int): Post {

        val res= postApi.getPost(id).await()


        return res

    }


    suspend fun getComments(id:Int): List<Comment> {

        val res= postApi.getComments(id).await()

        return res

    }



}
