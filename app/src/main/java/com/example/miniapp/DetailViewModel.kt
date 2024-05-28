package com.example.miniapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel : ViewModel() {

    val api = ApiClient.createApi()
    val product = MutableLiveData<Model>()
    val loading = MutableLiveData<Boolean>()

    fun getProduct(id: Int) {

        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.getToApiById(id)

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        response.body()?.let {
                            product.value = it

                        }
                    }
                }
            } finally {
                withContext(Dispatchers.Main) {
                    loading.value = false
                }
            }


        }
    }
}