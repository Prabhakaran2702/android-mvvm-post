package com.example.justclean_mvvm_post.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.justclean_mvvm_post.data.model.Favourite
import com.example.justclean_mvvm_post.data.model.Post
import com.example.justclean_mvvm_post.databinding.FavouriteItemBinding
import com.example.justclean_mvvm_post.databinding.PostItemBinding
import com.example.justclean_mvvm_post.ui.favourites.FavouritesFragmentDirections
import com.example.justclean_mvvm_post.ui.post.PostFragmentDirections
import com.example.justclean_mvvm_post.utils.Type
import kotlinx.android.synthetic.main.post_item.view.*


class FavouriteListAdapter(val postsList: ArrayList<Favourite>) : RecyclerView.Adapter<FavouriteListAdapter.FavouriteViewHolder>(),
    PostClickListener {

    class FavouriteViewHolder(var view: FavouriteItemBinding) : RecyclerView.ViewHolder(view.root)

    fun updatePostList(posts: ArrayList<Favourite>) {
        postsList.clear()
        postsList.addAll(posts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = FavouriteItemBinding.inflate(inflater,parent, false)
        return FavouriteViewHolder(view)
    }

    override fun getItemCount() = postsList.size

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.view.post = postsList[position]
        holder.view.listener = this
    }

    override fun onPostClicked(v: View) {
        val id = v.postid.text.toString().toInt()

        val action = FavouritesFragmentDirections.actionNavigationFavouritesToScrollingFragment(true)
        action.postId=id
        Navigation.findNavController(v).navigate(action)

    }

}
