package com.neecs.redditclone

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.neecs.redditclone.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PostsAdapter()
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        lifecycleScope.launch {
            postViewModel.uiState.collect { state ->
                if (state.isLoading) {
                    // Mostrar indicador de carga
                } else {
                    adapter.submitList(state.posts)
                }

                state.errorMessage?.let {
                    // Mostrar mensaje de error
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("com.neecs.redditclone.com.neecs.redditclone.MainActivity", "onDestroy")
    }
}