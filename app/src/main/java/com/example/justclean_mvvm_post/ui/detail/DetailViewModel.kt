package com.example.justclean_mvvm_post.ui.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justclean_mvvm_post.BaseViewModel
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.DetailRepository
import kotlinx.coroutines.launch

class DetailViewModel(application: Application, private val repository: DetailRepository) : BaseViewModel(application) {


    private val _comments = MutableLiveData<ArrayList<Comment>>()
    private val _post = MutableLiveData<Post>()

    val comments: LiveData<ArrayList<Comment>> = _comments
    val post: LiveData<Post> = _post


    fun fetchPost(id:Int){

        launch {
            _post.value=repository.getPost(id)
            val array = arrayListOf<Comment>()
            array.addAll(repository.getComments(id))
            _comments.value= array
        }
    }


    fun addFavourite(fav:Favourite){

        launch {
            repository.addFavourite(fav)
        }

    }


    fun deleteFavourite(id:Int){

        launch {
            repository.deleteFavourite(id)
        }

    }


}