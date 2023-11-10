package com.example.retrofit_test1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_test1.model.Todo
import com.example.retrofit_test1.network.ApiService
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    var movieListResponse: List<Todo> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    val  apiService = ApiService.getInstance()
    fun getMovieList() {
        viewModelScope.launch {
            try {
                movieListResponse = apiService.getMovies()
            }catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}