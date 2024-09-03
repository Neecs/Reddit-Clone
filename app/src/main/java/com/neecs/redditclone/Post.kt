package com.neecs.redditclone

import androidx.annotation.DrawableRes

data class Post(
    val communityName: String,
    val title: String,
    val content: String,
    @DrawableRes val drawableRes: Int
)