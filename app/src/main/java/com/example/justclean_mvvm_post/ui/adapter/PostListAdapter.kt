package com.example.justclean_mvvm_post.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.justclean_mvvm_post.R
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.databinding.PostItemBinding
import com.example.justclean_mvvm_post.ui.favourites.FavouritesFragmentDirections
import com.example.justclean_mvvm_post.ui.post.PostFragmentDirections
import com.example.justclean_mvvm_post.utils.Type
import kotlinx.android.synthetic.main.post_item.view.*

class PostListAdapter(val postsList: ArrayList<Post>,val type: Type) : RecyclerView.Adapter<PostListAdapter.PostViewHolder>(),
    PostClickListener {

    class PostViewHolder(var view: PostItemBinding) : RecyclerView.ViewHolder(view.root)

    fun updatePostList(posts: ArrayList<Post>) {
        postsList.clear()
        postsList.addAll(posts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =PostItemBinding.inflate(inflater,parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount() = postsList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.view.post = postsList[position]
        holder.view.listener = this
    }

    override fun onPostClicked(v: View) {
        val id = v.postid.text.toString().toInt()


        if(type==Type.POSTS){
            val action = PostFragmentDirections.actionNavigationPostToScrollingFragment()
            action.postId=id
            Navigation.findNavController(v).navigate(action)
        }
        else{
            val action = FavouritesFragmentDirections.actionNavigationFavouritesToScrollingFragment()
            action.postId=id
            Navigation.findNavController(v).navigate(action)
        }

    }

}
