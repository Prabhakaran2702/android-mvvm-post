package com.example.justclean_mvvm_post.ui.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.justclean_mvvm_post.ui.base.BaseViewModel
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.DetailRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailViewModel(application: Application, private val repository: DetailRepository) : BaseViewModel(application) {


    private val _comments = MutableLiveData<ArrayList<Comment>>()
    private val _post = MutableLiveData<Post>()

    val comments: LiveData<ArrayList<Comment>> = _comments
    val post: LiveData<Post> = _post

    private lateinit var job: Job


    fun fetchPost(id:Int){

        job=  viewModelScope.launch {
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


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}