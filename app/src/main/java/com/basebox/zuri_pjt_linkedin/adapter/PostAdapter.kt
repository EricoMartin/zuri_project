package com.basebox.zuri_pjt_linkedin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basebox.zuri_pjt_linkedin.databinding.PostListItemBinding
import com.basebox.zuri_pjt_linkedin.model.PostModel

class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val posts = mutableListOf<PostModel>()
    inner class PostViewHolder(private val binding: PostListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(post: PostModel) {
            binding.textViewName.text = post.name
            binding.textPost.text = post.post
            binding.img.setImageResource(post.img)
        }
    }
    fun setUpPosts(posts: List<PostModel>){
        this.posts.addAll(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bindItem(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}