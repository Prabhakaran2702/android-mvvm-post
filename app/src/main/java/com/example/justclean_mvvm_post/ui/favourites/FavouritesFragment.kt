package com.example.justclean_mvvm_post.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justclean_mvvm_post.R
import com.example.justclean_mvvm_post.databinding.FragmentFavouritesBinding
import com.example.justclean_mvvm_post.ui.adapter.FavouriteListAdapter
import com.example.justclean_mvvm_post.ui.adapter.PostListAdapter
import com.example.justclean_mvvm_post.ui.post.PostViewModel
import com.example.justclean_mvvm_post.utils.Type
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.viewmodel.ext.android.viewModel

class FavouritesFragment : Fragment() {



    private val viewModel: FavouritesViewModel by viewModel<FavouritesViewModel>()

    private lateinit var binding: FragmentFavouritesBinding

    private val postsListAdapter = FavouriteListAdapter(arrayListOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding=FragmentFavouritesBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postsListAdapter
        }

        binding.refreshLayout.setOnRefreshListener {
            binding.postList.visibility = View.GONE
            binding. listError.visibility = View.GONE
            binding. loadingView.visibility = View.VISIBLE
            binding. refreshLayout.isRefreshing = false
        }

        observeViewModel()

        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility=View.VISIBLE

        viewModel.fetchData()

    }


    private fun observeViewModel() {
        viewModel.posts.observe(viewLifecycleOwner, Observer {post ->
            post?.let {
                binding.postList.visibility = View.VISIBLE
                postsListAdapter.updatePostList(post)
            }
        })

        viewModel.loadError.observe(viewLifecycleOwner, Observer {isError ->
            isError?.let {
                binding. listError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading?.let {
                binding. loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    binding. listError.visibility = View.GONE
                    binding.postList.visibility = View.GONE
                }
            }
        })
    }



}