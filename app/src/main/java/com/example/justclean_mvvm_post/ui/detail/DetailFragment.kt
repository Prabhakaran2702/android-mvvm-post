package com.example.justclean_mvvm_post.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justclean_mvvm_post.R
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.databinding.FragmentDetailBinding
import com.example.justclean_mvvm_post.ui.adapter.CommentListAdapter
import com.example.justclean_mvvm_post.ui.adapter.PostListAdapter
import com.example.justclean_mvvm_post.ui.post.PostViewModel
import com.example.justclean_mvvm_post.utils.Type
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModel<DetailViewModel>()
    private val commentAdapter = CommentListAdapter(arrayListOf())
    private var postId = 0
    private lateinit var _post:Post
    private var isFavouriteAdded= false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observerData()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideBottomNav()
        binding.CommentList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = commentAdapter

            arguments?.let {
                postId = DetailFragmentArgs.fromBundle(it).postId
                isFavouriteAdded= DetailFragmentArgs.fromBundle(it).isFavouriteView
            }

            viewModel.fetchPost(postId)

            if(isFavouriteAdded){
                binding.addFav.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
            else{
                binding.addFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }


            binding.addFav.setOnClickListener {

                if(isFavouriteAdded){

                    binding.addFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    viewModel.deleteFavourite(_post.id)
                    isFavouriteAdded=false

                }
                else{

                    binding.addFav.setImageResource(R.drawable.ic_baseline_favorite_24)
                    viewModel.addFavourite(Favourite(_post.id,_post.userId,_post.title,_post.body))
                    isFavouriteAdded=true

                }

            }

        }
    }

    private fun observerData(){

        viewModel.post.observe(this, Observer {post ->
            post?.let {
                _post=post
                binding.name.text=post.title
                binding.body.text=post.body

            }
        })

        viewModel.comments.observe(this, Observer {post ->
            post?.let {
                binding.CommentList.visibility = View.VISIBLE
                commentAdapter.updateCommentList(post)
            }
        })

    }

    private fun hideBottomNav(){
        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility=View.GONE
    }

}