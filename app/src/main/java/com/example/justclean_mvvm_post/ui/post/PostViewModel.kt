package com.example.justclean_mvvm_post.ui.post

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.PostRepository
import com.example.justclean_mvvm_post.ui.base.BaseViewModel
import com.example.justclean_mvvm_post.utils.Util
import kotlinx.coroutines.launch

class PostViewModel(application: Application, private val repository: PostRepository) : BaseViewModel(application){

    private val _posts = MutableLiveData<ArrayList<Post>>()
    private val _loadError = MutableLiveData<Boolean>().apply {
        value =false
    }
    private val _loading = MutableLiveData<Boolean>().apply {
        value = true
    }


    val posts: LiveData<ArrayList<Post>> = _posts
    val loadError: LiveData<Boolean> = _loadError
    val loading: LiveData<Boolean> = _loading


     fun fetchData(){

         val job =  launch {

            val array = arrayListOf<Post>()
            array.addAll(repository.getPosts())
            _posts.value= array
            _loadError.value = false
            _loading.value = false

        }




    }

}