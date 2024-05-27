package com.example.miniapp

class ApiClient {

    companion object {
        fun createApi(): ApiService{
            return RetrofitClient.api
        }
    }
}