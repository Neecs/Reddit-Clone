package com.neecs.redditclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neecs.redditclone.databinding.ViewPostBinding

class PostsAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = posts.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(posts[position])
    }


    class ViewHolder(private val binding: ViewPostBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(post:Post){
           binding.comunnityTitle.text = post.communityName
        }
    }
}