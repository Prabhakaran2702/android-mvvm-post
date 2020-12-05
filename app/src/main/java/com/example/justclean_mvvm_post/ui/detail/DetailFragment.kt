package com.example.justclean_mvvm_post.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justclean_mvvm_post.R
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

    private val adapter = CommentListAdapter(arrayListOf())


    private var postId = 0

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
            adapter = adapter

            arguments?.let {
                postId = DetailFragmentArgs.fromBundle(it).postId
            }

            viewModel.fetchPost(postId)

        }

    }

    fun observerData(){

        viewModel.comments.observe(this, Observer {post ->
            post?.let {
                binding.CommentList.visibility = View.VISIBLE
                adapter.updateCommentList(post)
            }
        })

        viewModel.post.observe(this, Observer {post ->
            post?.let {
                binding.name.text=post.title
                binding.body.text=post.body

            }
        })


    }


    private fun hideBottomNav(){

        val navBar: BottomNavigationView = requireActivity().findViewById(R.id.nav_view)
        navBar.visibility=View.GONE

    }

}