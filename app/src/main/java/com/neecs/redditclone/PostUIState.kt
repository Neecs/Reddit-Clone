package com.neecs.redditclone


data class PostUIState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
