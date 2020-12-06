package com.example.justclean_mvvm_post.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.FavouriteRepository
import com.example.justclean_mvvm_post.data.repository.PostRepository
import kotlinx.coroutines.launch

class FavouritesViewModel(private val repository: FavouriteRepository) : ViewModel() {


    private val _posts = MutableLiveData<ArrayList<Favourite>>()
    private val _loadError = MutableLiveData<Boolean>().apply {
        value =false
    }
    private val _loading = MutableLiveData<Boolean>().apply {
        value = true
    }

    val posts: LiveData<ArrayList<Favourite>> = _posts
    val loadError: LiveData<Boolean> = _loadError
    val loading: LiveData<Boolean> = _loading



     fun fetchData(){

        viewModelScope.launch {

            val array = arrayListOf<Favourite>()
            array.addAll(repository.getFavourites())
            _posts.value= array
            _loadError.value = false
            _loading.value = false

        }

    }

}