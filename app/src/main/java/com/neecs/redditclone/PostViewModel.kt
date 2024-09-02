package com.neecs.redditclone

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PostViewModel : ViewModel() {
    private val _postList = MutableStateFlow<List<Post>>(emptyList())
    val postList: StateFlow<List<Post>> get() = _postList

    init {
        fillPostList()
    }

    private fun fillPostList() {
        val posts = mutableListOf<Post>()
        for (i in 0 until 5) {
            posts.add(Post("r/Community $i"))
        }
        _postList.value = posts
    }

    fun addPost(post: Post) {
        _postList.update { currentList ->
            currentList + post
        }
    }

    fun removePost(post: Post) {
        _postList.update { currentList ->
            currentList - post
        }
    }
}
