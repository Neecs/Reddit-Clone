package com.neecs.redditclone

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var llPosts: LinearLayout
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fillPostList()
        addPostsToLL()
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("r/Community $i"))
        }
    }


    private fun addPostsToLL() {
        postList.forEach { post ->
            val postView = layoutInflater.inflate(R.layout.reddit_home, null)

            val tvCommunityName: TextView = postView.findViewById(R.id.comunnityTitle)
            tvCommunityName.text = post.communityName

            llPosts.addView(postView)
        }
    }

    private fun initViews() {
        llPosts = findViewById(R.id.Ll_posts)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}

