package com.neecs.redditclone

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.neecs.redditclone.databinding.ActivityMainBinding
import com.neecs.redditclone.databinding.ViewPostBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillPostList()
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("r/Community $i"))
        }

        binding.recycler.adapter = PostsAdapter(postList)
    }





    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}

