package com.example.miniapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/v1/products")
    suspend fun getTodoApi(): Response<TodoResponse<Any?>>

    @GET("api/v1/products/{id}")
    suspend fun getToApiById(@Path("id") id: Int): Response<Model>

}