package com.example.justclean_mvvm_post.ui.favourites

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.data.repository.FavouriteRepository
import com.example.justclean_mvvm_post.data.repository.PostRepository
import com.example.justclean_mvvm_post.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class FavouritesViewModel(application: Application, private val repository: FavouriteRepository) : BaseViewModel(application) {


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

        launch {
            val array = arrayListOf<Favourite>()
            array.addAll(repository.getFavourites())
            _posts.value= array
            _loadError.value = false
            _loading.value = false
        }

    }

}