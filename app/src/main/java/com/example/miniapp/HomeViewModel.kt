package com.example.miniapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    val repo = TodoRepository()

    val todos = MutableLiveData<List<Model>>()
    val error = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    init {
        getData()
    }

    fun getData() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repo.getTodoApi()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        response.body()?.let {
                            todos.value = it
                            if (it.isNotEmpty()) {
                            } else {
                                error.value = "Item Tapilmamishdir "
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    error.value = e.localizedMessage ?: ""
                }
            } finally {
                withContext(Dispatchers.Main) {
                    loading.value = false
                }
            }
        }
    }
}