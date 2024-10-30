package com.neecs.redditclone

import com.neecs.redditclone.ui.theme.Post


data class PostUIState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
