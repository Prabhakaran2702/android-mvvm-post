package com.example.justclean_mvvm_post.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val _posts = MutableLiveData<ArrayList<Post>>()
    val _loadError = MutableLiveData<Boolean>().apply {
        value =false
    }
    val _loading = MutableLiveData<Boolean>().apply {
        value = true
    }


    val posts: LiveData<ArrayList<Post>> = _posts
    val loadError: LiveData<Boolean> = _loadError
    val loading: LiveData<Boolean> = _loading


    init {

       // loadDummy()

        fetchData()

    }


    fun loadDummy(){

        val list: ArrayList<Post> = ArrayList()
        list.add(Post(1,1,"Title1","body"))
        list.add(Post(1,1,"Title2","body"))
        list.add(Post(1,1,"Title3","body"))
        _posts.value=list
        _loadError.value = false
        _loading.value = false

    }


    fun fetchData(){

        viewModelScope.launch {

            val array = arrayListOf<Post>()
            array.addAll(repository.getPost())
            _posts.value= array
            _loadError.value = false
            _loading.value = false

        }


    }

}