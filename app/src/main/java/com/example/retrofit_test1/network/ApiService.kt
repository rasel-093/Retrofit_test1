package com.example.retrofit_test1.network

import com.example.retrofit_test1.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getMovies(): List<Todo>

    companion object{
        var  apiService: ApiService? = null

        fun getInstance(): ApiService{
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}