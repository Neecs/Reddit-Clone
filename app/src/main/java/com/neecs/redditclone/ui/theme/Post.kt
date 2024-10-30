package com.neecs.redditclone.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.neecs.redditclone.R

data class Post(val communityName: String, val title: String, val content: String, val postImageRes: Int, val communityImageRes: Int)

val samplePosts = listOf(
    Post("r/Community1", "Post 1", "Content 1", R.drawable.golden, R.drawable.dog),
    Post("r/Community2", "Post 2", "Content 2", R.drawable.golden, R.drawable.dog),
    Post("r/Community3", "Post 3", "Content 3", R.drawable.golden, R.drawable.dog),
    Post("r/Community4", "Post 4", "Content 4", R.drawable.golden, R.drawable.dog),
    Post("r/Community5", "Post 5", "Content 5", R.drawable.golden, R.drawable.dog),
    Post("r/Community6", "Post 6", "Content 6", R.drawable.golden, R.drawable.dog),
    Post("r/Community7", "Post 7", "Content 7", R.drawable.golden, R.drawable.dog),
    Post("r/Community8", "Post 8", "Content 8", R.drawable.golden, R.drawable.dog)
)

@Composable
fun PostList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(samplePosts) { post ->
            PostItem(post)
        }
    }
}

@Composable
fun PostItem(post: Post) {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

        val (communityImage, communityTitle, optionsButton, postTitle, postText, postImage, upvote, downvote, comments, medal, share) = createRefs()

        Image(
            painter = painterResource(id = post.communityImageRes),
            contentDescription = null,
            modifier = Modifier
                .size(77.dp, 48.dp)
                .constrainAs(communityImage) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start, margin = 44.dp)
                }
        )

        Text(
            text = post.communityName,
            modifier = Modifier.constrainAs(communityTitle) {
                top.linkTo(parent.top)
                start.linkTo(communityImage.end)
                bottom.linkTo(communityImage.bottom)
            }
        )

        Image(
            painter = painterResource(id = R.drawable.dot),
            contentDescription = null,
            modifier = Modifier
                .size(61.dp, 34.dp)
                .constrainAs(optionsButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end, margin = 8.dp)
                }
        )

        Text(
            text = post.title,
            modifier = Modifier.constrainAs(postTitle) {
                top.linkTo(communityImage.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = post.content,
            modifier = Modifier.constrainAs(postText) {
                top.linkTo(postTitle.bottom, margin = 4.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Image(
            painter = painterResource(id = post.postImageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 256.dp)
                .constrainAs(postImage) {
                    top.linkTo(postText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.uparrow),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .constrainAs(upvote) {
                    top.linkTo(postImage.bottom)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.arrowdown),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .constrainAs(downvote) {
                    top.linkTo(postImage.bottom)
                    start.linkTo(upvote.end, margin = 16.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.comments),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .constrainAs(comments) {
                    top.linkTo(postImage.bottom)
                    start.linkTo(downvote.end, margin = 16.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.medalla),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .constrainAs(medal) {
                    top.linkTo(postImage.bottom)
                    start.linkTo(comments.end, margin = 16.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.compartir),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .constrainAs(share) {
                    top.linkTo(postImage.bottom)
                    start.linkTo(medal.end, margin = 16.dp)
                }
        )
    }
}