package com.neecs.redditclone

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PostViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PostUIState())
    val uiState: StateFlow<PostUIState> get() = _uiState

    init {
        loadPosts()
    }

    private fun loadPosts() {
        _uiState.value = PostUIState(isLoading = true)

        val posts = List(10) { index ->
            Post(
                communityName = "r/Community $index",
                title = "Post Title $index",
                content = "This is the content of post $index",
                drawableRes = R.drawable.golden
            )
        }

        _uiState.value = PostUIState(posts = posts, isLoading = false)
    }

    fun addPost(post: Post) {
        _uiState.update { currentState ->
            currentState.copy(posts = currentState.posts + post)
        }
    }

    fun removePost(post: Post) {
        _uiState.update { currentState ->
            currentState.copy(posts = currentState.posts - post)
        }
    }

    fun setError(message: String) {
        _uiState.update { currentState ->
            currentState.copy(isLoading = false, errorMessage = message)
        }
    }
}