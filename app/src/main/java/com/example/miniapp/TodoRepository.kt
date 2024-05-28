package com.example.miniapp

import retrofit2.Response

class TodoRepository {

    private val api = RetrofitClient.api

    suspend fun getTodoApi(): Response<TodoResponse<Any?>> {
        return api.getTodoApi()
    }
}