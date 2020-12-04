package com.example.justclean_mvvm_post.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.justclean_mvvm_post.data.model.Comment
import com.example.justclean_mvvm_post.databinding.CommentItemBinding


class CommentListAdapter (val commentsList: ArrayList<Comment>) : RecyclerView.Adapter<CommentListAdapter.CommentViewHolder>()
     {


    class CommentViewHolder(var view: CommentItemBinding) : RecyclerView.ViewHolder(view.root)

         fun updateCommentList(commentList: ArrayList<Comment>) {
             commentList.clear()
             commentList.addAll(commentList)
             notifyDataSetChanged()
         }

         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentListAdapter.CommentViewHolder {
             val inflater = LayoutInflater.from(parent.context)
             val view = CommentItemBinding.inflate(inflater,parent, false)
             return CommentViewHolder(view)
         }

         override fun getItemCount() = commentsList.size

         override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
             holder.view.comment = commentsList[position]

         }



     }