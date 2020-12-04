package com.example.justclean_mvvm_post.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.justclean_mvvm_post.data.model.Post

class FavouritesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is favourites Fragment"
    }

    val posts = MutableLiveData<ArrayList<Post>>().apply {   var p = Post(1,1,"Title","body")
        value?.add(p)
    }
    val loadError = MutableLiveData<Boolean>().apply {
        value =false
    }
    val loading = MutableLiveData<Boolean>().apply {
        value = true
    }

    val text: LiveData<String> = _text

    init {
        loadDummy()
    }


    fun loadDummy(){

        val list: ArrayList<Post> = ArrayList()
        list.add(Post(1,1,"Title1","body"))

        posts.value=list
        loadError.value = false
        loading.value = false

    }

}