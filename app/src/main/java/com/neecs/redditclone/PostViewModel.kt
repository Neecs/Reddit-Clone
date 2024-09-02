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
        // Simular carga de datos
        _uiState.value = PostUIState(isLoading = true)

        // Simulación de carga de datos
        // En una aplicación real, aquí se realizaría una solicitud de red o una operación de base de datos.
        val posts = List(10) { index -> Post("r/Community $index") }

        // Actualizar el estado con los datos cargados
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
