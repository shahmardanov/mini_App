package com.example.miniapp

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/products")
    suspend fun getTodoApi(): Response<TodoResponse>

}