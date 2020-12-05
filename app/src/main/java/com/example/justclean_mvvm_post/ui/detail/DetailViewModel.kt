package com.example.justclean_mvvm_post.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.PostRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: PostRepository) : ViewModel() {


    val _comments = MutableLiveData<ArrayList<Comment>>()
    val _post = MutableLiveData<Post>()

    val comments: LiveData<ArrayList<Comment>> = _comments
    val post: LiveData<Post> = _post


    fun fetchPost(id:Int){


        viewModelScope.launch {

            _post.value=repository.getPost(id)

            val array = arrayListOf<Comment>()
            array.addAll(repository.getComments(id))
            _comments.value= array

        }

    }


}